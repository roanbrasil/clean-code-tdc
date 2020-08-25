package com.tdc.cleancode.complex.after;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tdc.cleancode.complex.dto.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class ComplexMapperCleanCode {


    public Payment fromComplexDataStreamExampleToPayment(
            final ComplexDataStreamExample response, final String paymentMethodToSearch){

        var payment = new Payment();
        payment.setPaymentMethod(PaymentMethod.valueOf(paymentMethodToSearch));

        final List<Complex> complexList = response.getComplexGroupList().get(0).getComplexList();

        final List<Complex> complexListFiltered = complexList
                .stream()
                .filter(complexFilterByPaymentMethod(paymentMethodToSearch))
                .collect(Collectors.toList());


        complexListFiltered
                .forEach(complex -> fillResponse(payment, complex));

        return null;
    }

    private void fillResponse(final Payment payment, final Complex complex) {
        final String amountValueType = getCurrentPaymentMethod(complex).getAttributeValue();
        complex
                .getComplexDomainStructure()
                .getTarget()
                .getSimpleValueList()
                .forEach(simpleValue -> {
                    final Debit debit = this.getDebit(payment, simpleValue);

                    ValueType.findByName(amountValueType).setDebit(debit, simpleValue.getAttributeValue());
                });
    }

    private Debit getDebit(Payment payment, SimpleValue simpleValue){
        return payment.getDebitList()
                .stream()
                .filter(debit -> debit != null && debit.getPaymentTypeDescription().equals(simpleValue.getAttributeName()))
                .findFirst()
                .or(() -> debitMapping(payment, simpleValue).get())
                .orElseThrow(IllegalArgumentException::new);
    }

    private SimpleValue getCurrentPaymentMethod(Complex complex){
        return complex.getComplexDomainStructure().getSimpleValueList()
                .stream()
                .filter(simpleValue -> "paymentMethod".equals(simpleValue.getAttributeName()))
                .findFirst()
                .orElseThrow();
    }

    private Supplier<Optional<Debit>> debitMapping(Payment payment, SimpleValue simpleValue) {
        return () -> {
            final Debit debit = new Debit();
            debit.setPaymentTypeDescription(simpleValue.getAttributeName());
            payment.getDebitList().add(debit);
            return Optional.ofNullable(debit);
        };
    }

    private Predicate<Complex> complexFilterByPaymentMethod(String paymentMethodToSearch){
        return complex -> complex.getComplexDomainStructure().getSimpleValueList()
                .stream()
                .anyMatch(simpleValue ->
                        "billType".equalsIgnoreCase(simpleValue.getAttributeName())
                                && simpleValue.getAttributeValue().equalsIgnoreCase(paymentMethodToSearch));
    }









    public static void main(String[] args) throws JsonProcessingException {

        //PART 1
        SimpleValue valueTypeSimpleValue1 = new SimpleValue("AMOUNT_DUE", "100.00");
        SimpleValue valueTypeSimpleValue2 = new SimpleValue("TOTAL_AMOUNT_DUE", "1000.00");
        SimpleValue valueTypeSimpleValue3 = new SimpleValue("TOTAL_AMOUNT_SPENT", "2000.00");
        List<SimpleValue> valueTypeValueList1 = List.of(valueTypeSimpleValue1, valueTypeSimpleValue2, valueTypeSimpleValue3);

        Target target1 = new Target();
        target1.setId(54321L);
        target1.setName("billType");
        target1.setSimpleValueList(valueTypeValueList1);

        SimpleValue complexDomainStructureSimpleValue1 = new SimpleValue("billType", "CREDIT_CARD");
        SimpleValue complexDomainStructureSimpleValue2 = new SimpleValue("paymentMethod", "INSTALLMENT");
        List<SimpleValue> complexDomainStructureSimpleValueList1 = List.of(complexDomainStructureSimpleValue1, complexDomainStructureSimpleValue2);

        ComplexDomainStructure complexDomainStructure1 = new ComplexDomainStructure();
        complexDomainStructure1.setId(123456L);
        complexDomainStructure1.setSimpleValueList(complexDomainStructureSimpleValueList1);
        complexDomainStructure1.setTarget(target1);

        Complex complex1 = new Complex();
        complex1.setEndDate(LocalDate.now().plusDays(365));
        complex1.setEndDate(LocalDate.now().minusDays(10));
        complex1.setComplexDomainStructure(complexDomainStructure1);


        //PART 2

        SimpleValue valueTypeSimpleValue4 = new SimpleValue("AMOUNT_DUE", "200.00");
        SimpleValue valueTypeSimpleValue5 = new SimpleValue("TOTAL_AMOUNT_DUE", "200.00");
        SimpleValue valueTypeSimpleValue6 = new SimpleValue("TOTAL_AMOUNT_SPENT", "200.00");
        List<SimpleValue> valueTypeValueList2 = List.of(valueTypeSimpleValue4, valueTypeSimpleValue5, valueTypeSimpleValue6);

        Target target2 = new Target();
        target2.setId(54321L);
        target2.setName("billType");
        target2.setSimpleValueList(valueTypeValueList2);

        SimpleValue complexDomainStructureSimpleValue3 = new SimpleValue("billType", "CREDIT_CARD");
        SimpleValue complexDomainStructureSimpleValue4 = new SimpleValue("paymentMethod", "CASH_VALUE");
        List<SimpleValue> complexDomainStructureSimpleValueList2 = List.of(complexDomainStructureSimpleValue3, complexDomainStructureSimpleValue4);

        ComplexDomainStructure complexDomainStructure2 = new ComplexDomainStructure();
        complexDomainStructure2.setId(123456L);
        complexDomainStructure2.setSimpleValueList(complexDomainStructureSimpleValueList2);
        complexDomainStructure2.setTarget(target2);

        Complex complex2 = new Complex();
        complex2.setEndDate(LocalDate.now().plusDays(365));
        complex2.setEndDate(LocalDate.now().minusDays(10));
        complex2.setComplexDomainStructure(complexDomainStructure2);

        //PART 3
        SimpleValue valueTypeSimpleValue7 = new SimpleValue("AMOUNT_DUE", "300.00");
        SimpleValue valueTypeSimpleValue8 = new SimpleValue("TOTAL_AMOUNT_DUE", "3000.00");
        SimpleValue valueTypeSimpleValue9 = new SimpleValue("TOTAL_AMOUNT_SPENT", "3300.00");
        List<SimpleValue> valueTypeValueList3 = List.of(valueTypeSimpleValue7, valueTypeSimpleValue8, valueTypeSimpleValue9);

        Target target3 = new Target();
        target3.setId(54321L);
        target3.setName("billType");
        target3.setSimpleValueList(valueTypeValueList3);

        SimpleValue complexDomainStructureSimpleValue5 = new SimpleValue("billType", "LOAN");
        SimpleValue complexDomainStructureSimpleValue6 = new SimpleValue("paymentMethod", "INSTALLMENT");
        List<SimpleValue> complexDomainStructureSimpleValueList3 = List.of(complexDomainStructureSimpleValue5, complexDomainStructureSimpleValue6);

        ComplexDomainStructure complexDomainStructure3 = new ComplexDomainStructure();
        complexDomainStructure3.setId(123456L);
        complexDomainStructure3.setSimpleValueList(complexDomainStructureSimpleValueList3);
        complexDomainStructure3.setTarget(target3);

        Complex complex3 = new Complex();
        complex3.setEndDate(LocalDate.now().plusDays(365));
        complex3.setEndDate(LocalDate.now().minusDays(10));
        complex3.setComplexDomainStructure(complexDomainStructure3);

        List<Complex> complexList = List.of(complex1, complex2, complex3);

        ComplexGroup complexGroup = new ComplexGroup();
        complexGroup.setListName("TDC-Stream-Example");
        complexGroup.setComplexList(complexList);

        List<ComplexGroup> complexGroups = new ArrayList<>();
        complexGroups.add(complexGroup);

        ComplexDataStreamExample complexDataStreamExample = new ComplexDataStreamExample();
        complexDataStreamExample.setCountry("BRA");
        complexDataStreamExample.setComplexGroupList(complexGroups);

        ComplexMapperCleanCode mapperCleanCode = new ComplexMapperCleanCode();
        Payment payment = mapperCleanCode.fromComplexDataStreamExampleToPayment(complexDataStreamExample, "CREDIT_CARD");
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(payment);
        System.out.println(json);
    }
}
