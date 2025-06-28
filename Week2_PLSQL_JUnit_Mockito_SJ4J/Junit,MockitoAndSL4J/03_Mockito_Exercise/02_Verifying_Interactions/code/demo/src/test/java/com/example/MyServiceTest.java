package com.example;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.*;

public class MyServiceTest{
    @Test
    public void testProcessData() {
        // Arrange
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        when(mockApi.fetchData()).thenReturn("Mocked Data");
        
        MyService myService = new MyService(mockApi);
        
        // Act
        String result = myService.processData();
        
        // Assert
        assertEquals("Processed: Mocked Data", result);
        
        // Verify interaction
        verify(mockApi).fetchData();
    }
}