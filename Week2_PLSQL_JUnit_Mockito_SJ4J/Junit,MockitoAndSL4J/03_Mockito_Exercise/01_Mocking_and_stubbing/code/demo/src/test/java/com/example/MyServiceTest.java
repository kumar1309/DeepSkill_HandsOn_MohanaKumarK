package com.example;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
public class MyServiceTest{
    @Test
    public void testFetchData() {
        // Arrange
        ExternalApi mockApi = mock(ExternalApi.class);
        when(mockApi.getData()).thenReturn("Mocked Data");
        MyService myService = new MyService(mockApi);

        // Act
        String result = myService.fetchData();

        // Assert
        assertEquals("Mocked Data", result);
    }
}