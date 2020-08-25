package com.tdc.cleancode.complex.before;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tdc.cleancode.complex.dto.*;

import java.time.LocalDate;
import java.util.*;


public class ComplexMapper {

    private final Set<PaymentType> paymentTypes =  Set.of(PaymentType.CASH_VALUE, PaymentType.INSTALLMENT);
    private final Map<ValueType, Set<PaymentType>> paymentMethoMap = Map.ofEntries(
            Map.entry(ValueType.AMOUNT_DUE, paymentTypes),
            Map.entry(ValueType.TOTAL_AMOUNT_DUE, paymentTypes),
            Map.entry(ValueType.TOTAL_AMOUNT_SPENT, paymentTypes));

    public Payment fromComplexDataStreamExampleToPayment(
            PaymentDataStream response, String paymentMethodToSearch){

        var payment = new Payment();
        payment.setPaymentMethod(PaymentMethod.valueOf(paymentMethodToSearch));

        Map<PaymentType, Map<ValueType, String>> paymentValueTypeMap = this.processFromJsonToMap(response, paymentMethodToSearch);

        System.out.println(paymentValueTypeMap);

        List<Debit> debitList = new ArrayList<>();
        for (Map.Entry<PaymentType, Map<ValueType, String>> paymentValueType : paymentValueTypeMap.entrySet()) {
            Map<ValueType, String> valueType = paymentValueType.getValue();
            Debit debit = new Debit();
            debit.setPaymentTypeDescription(paymentValueType.getKey().toString());
            for(Map.Entry<ValueType, String> valueTypeEntry : valueType.entrySet()){
                if(ValueType.AMOUNT_DUE.equals(valueTypeEntry.getKey())){
                    debit.setAmountDue(valueTypeEntry.getValue());
                }else if (ValueType.TOTAL_AMOUNT_DUE.equals(valueTypeEntry.getKey())) {
                    debit.setTotalAmountDue(valueTypeEntry.getValue());
                } else if (ValueType.TOTAL_AMOUNT_SPENT.equals(valueTypeEntry.getKey())) {
                    debit.setTotalAmountSpent(valueTypeEntry.getValue());
                }
            }
            debitList.add(debit);
        }
        payment.setDebitList(debitList);

        return payment;
    }

    private Map<PaymentType, Map<ValueType, String>> processFromJsonToMap(PaymentDataStream response, String paymentMethodToSearch) {
        ObjectMapper mapper = new ObjectMapper();
        Map<PaymentType, Map<ValueType, String>> valueTypeMapLocal = new HashMap<>();

        try {
            String json = mapper.writeValueAsString(response);
            JsonNode jsonNode = mapper.readTree(json);

            List<JsonNode> complexDomainStructureList = jsonNode.findValues("complexDomainStructure");
            for(JsonNode complexDomainStructure: complexDomainStructureList){
                List<JsonNode> simpleValueListFromComplexDomain = complexDomainStructure.findValues("simpleValueList");
                var isPaymentMethodSearched = false;
                for(JsonNode simpleValue : simpleValueListFromComplexDomain.get(0)){
                    Map<ValueType, String> valueTypeMap = new HashMap<>();

                    if("billType".equals(simpleValue.findValue("attributeName").textValue())
                    && paymentMethodToSearch.equals(simpleValue.findValue("attributeValue").textValue())){
                        isPaymentMethodSearched = true;
                    }

                    if ("paymentMethod".equals(simpleValue.findValue("attributeName").textValue())
                       && isPaymentMethodSearched){

                        var paymentType = simpleValue.findValue("attributeValue").textValue();

                        for(JsonNode simpleValueFromTarget : simpleValueListFromComplexDomain.get(1)){
                                var value = ValueType.valueOf(
                                        simpleValueFromTarget.findValue("attributeName").textValue());
                                var amountValue = simpleValueFromTarget
                                        .findValue("attributeValue").textValue();
                                valueTypeMap.put(value, amountValue);
                        }

                        if (!valueTypeMap.isEmpty()){
                            valueTypeMapLocal.put(PaymentType.valueOf(paymentType), valueTypeMap);
                        }
                    }
                }
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            System.out.println("Json Conversion Exception");
        }
      return valueTypeMapLocal;
    }

    public static void main(String[] args) throws JsonProcessingException {

        //PART 1
        SimpleValue valueTypeSimpleValue1 = new SimpleValue("AMOUNT_DUE", "100.00");
        SimpleValue valueTypeSimpleValue2 = new SimpleValue("TOTAL_AMOUNT_DUE", "1000.00");
        SimpleValue valueTypeSimpleValue3 = new SimpleValue("TOTAL_AMOUNT_SPENT", "2000.00");
        List<SimpleValue>  valueTypeValueList1 = List.of(valueTypeSimpleValue1, valueTypeSimpleValue2, valueTypeSimpleValue3);

        Target target1 = new Target();
        target1.setId(54321L);
        target1.setName("billType");
        target1.setSimpleValues(valueTypeValueList1);

        SimpleValue complexDomainStructureSimpleValue1 = new SimpleValue("billType", "CREDIT_CARD");
        SimpleValue complexDomainStructureSimpleValue2 = new SimpleValue("paymentMethod", "INSTALLMENT");
        List<SimpleValue>  complexDomainStructureSimpleValueList1 = List.of(complexDomainStructureSimpleValue1, complexDomainStructureSimpleValue2);

        ComplexDomainStructure complexDomainStructure1 = new ComplexDomainStructure();
        complexDomainStructure1.setId(123456L);
        complexDomainStructure1.setSimpleValues(complexDomainStructureSimpleValueList1);
        complexDomainStructure1.setTarget(target1);

        Complex complex1 = new Complex();
        complex1.setEndDate(LocalDate.now().plusDays(365));
        complex1.setEndDate(LocalDate.now().minusDays(10));
        complex1.setComplexDomainStructure(complexDomainStructure1);


        //PART 2

        SimpleValue valueTypeSimpleValue4 = new SimpleValue("AMOUNT_DUE", "200.00");
        SimpleValue valueTypeSimpleValue5 = new SimpleValue("TOTAL_AMOUNT_DUE", "200.00");
        SimpleValue valueTypeSimpleValue6 = new SimpleValue("TOTAL_AMOUNT_SPENT", "200.00");
        List<SimpleValue>  valueTypeValueList2 = List.of(valueTypeSimpleValue4, valueTypeSimpleValue5, valueTypeSimpleValue6);

        Target target2 = new Target();
        target2.setId(54321L);
        target2.setName("billType");
        target2.setSimpleValues(valueTypeValueList2);

        SimpleValue complexDomainStructureSimpleValue3 = new SimpleValue("billType", "CREDIT_CARD");
        SimpleValue complexDomainStructureSimpleValue4 = new SimpleValue("paymentMethod", "CASH_VALUE");
        List<SimpleValue>  complexDomainStructureSimpleValueList2 = List.of(complexDomainStructureSimpleValue3, complexDomainStructureSimpleValue4);

        ComplexDomainStructure complexDomainStructure2 = new ComplexDomainStructure();
        complexDomainStructure2.setId(123456L);
        complexDomainStructure2.setSimpleValues(complexDomainStructureSimpleValueList2);
        complexDomainStructure2.setTarget(target2);

        Complex complex2 = new Complex();
        complex2.setEndDate(LocalDate.now().plusDays(365));
        complex2.setEndDate(LocalDate.now().minusDays(10));
        complex2.setComplexDomainStructure(complexDomainStructure2);

        //PART 3
        SimpleValue valueTypeSimpleValue7 = new SimpleValue("AMOUNT_DUE", "300.00");
        SimpleValue valueTypeSimpleValue8 = new SimpleValue("TOTAL_AMOUNT_DUE", "3000.00");
        SimpleValue valueTypeSimpleValue9 = new SimpleValue("TOTAL_AMOUNT_SPENT", "3300.00");
        List<SimpleValue>  valueTypeValueList3 = List.of(valueTypeSimpleValue7, valueTypeSimpleValue8, valueTypeSimpleValue9);

        Target target3 = new Target();
        target3.setId(54321L);
        target3.setName("billType");
        target3.setSimpleValues(valueTypeValueList3);

        SimpleValue complexDomainStructureSimpleValue5 = new SimpleValue("billType", "LOAN");
        SimpleValue complexDomainStructureSimpleValue6 = new SimpleValue("paymentMethod", "INSTALLMENT");
        List<SimpleValue>  complexDomainStructureSimpleValueList3 = List.of(complexDomainStructureSimpleValue5, complexDomainStructureSimpleValue6);

        ComplexDomainStructure complexDomainStructure3 = new ComplexDomainStructure();
        complexDomainStructure3.setId(123456L);
        complexDomainStructure3.setSimpleValues(complexDomainStructureSimpleValueList3);
        complexDomainStructure3.setTarget(target3);

        Complex complex3 = new Complex();
        complex3.setEndDate(LocalDate.now().plusDays(365));
        complex3.setEndDate(LocalDate.now().minusDays(10));
        complex3.setComplexDomainStructure(complexDomainStructure3);

        List<Complex> complexList = List.of(complex1, complex2, complex3);

        ComplexGroup complexGroup = new ComplexGroup();
        complexGroup.setListName("TDC-Stream-Example");
        complexGroup.setComplexes(complexList);

        PaymentDataStream paymentDataStream = new PaymentDataStream();
        paymentDataStream.setCountry("BRA");
        paymentDataStream.setComplexGroup(complexGroup);

        ComplexMapper mapper = new ComplexMapper();
        Payment payment = mapper.fromComplexDataStreamExampleToPayment(paymentDataStream, "CREDIT_CARD");
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(payment);
        System.out.println(json);
    }
}
