package lab06;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import java.util.*;
import java.util.stream.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;

class InvoiceFilterTest {
    private InvoiceFilter invoiceFilter;
    private IssuedInvoices issuedInvoices;

    @Test
    void allHighValueInvoices() {
        // every invoice in the list should be high-value
        Invoice inV1 = new Invoice(100); //high
        Invoice inV2 = new Invoice(200); //high
        Invoice inV3 = new Invoice(299); //high
        IssuedInvoices issuedInvoicesMock = mock(IssuedInvoices.class);
        invoiceFilter = new InvoiceFilter(issuedInvoicesMock);
        when(issuedInvoicesMock.all()).thenReturn(List.of(inV1, inV2, inV3));
        assertThat(invoiceFilter.lowValueInvoices()).containsExactlyInAnyOrder();
        verify(issuedInvoicesMock, times(1)).all();
        verifyNoMoreInteractions(issuedInvoicesMock);
    }

    @Test
    void allLowValueInvoices() {
        Invoice inV1 = new Invoice(1); //low
        Invoice inV2 = new Invoice(43); //low
        Invoice inV3 = new Invoice(99); //low
        IssuedInvoices issuedInvoicesMock = mock(IssuedInvoices.class);
        invoiceFilter = new InvoiceFilter(issuedInvoicesMock);
        when(issuedInvoicesMock.all()).thenReturn(List.of(inV1, inV2, inV3));
        assertThat(invoiceFilter.lowValueInvoices()).containsExactlyInAnyOrder(inV1, inV2, inV3);
        verify(issuedInvoicesMock, times(1)).all();
        verifyNoMoreInteractions(issuedInvoicesMock);
    }

    @Test
    void someLowValueInvoices() {
        // Some low value invoices, some high
        Invoice inV1 = new Invoice(1); //low
        Invoice inV2 = new Invoice(99); //low
        Invoice inV3 = new Invoice(199); //high
        IssuedInvoices issuedInvoicesMock = mock(IssuedInvoices.class);
        invoiceFilter = new InvoiceFilter(issuedInvoicesMock);
        when(issuedInvoicesMock.all()).thenReturn(List.of(inV1, inV2, inV3));
        assertThat(invoiceFilter.lowValueInvoices()).containsExactlyInAnyOrder(inV1, inV2);
        verify(issuedInvoicesMock, times(1)).all();
        verifyNoMoreInteractions(issuedInvoicesMock);
    }

}
