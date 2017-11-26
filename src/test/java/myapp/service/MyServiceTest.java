package myapp.service;

import org.junit.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import myapp.service.MyService;

public class MyServiceTest {
    private MyService myService;
    
    @Before
    public void setup() {
        myService = new MyService();
    }
    
    @After
    public void shutdown() {
        myService = null;
    }
    
    @Test
    public void testSum() {
        Assert.assertEquals(7,myService.sum(3, 4));
        Assert.assertEquals(5,myService.sum(3, 4));
    }

}
