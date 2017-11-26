package myapp.service;

import org.springframework.stereotype.Service;

import myapp.service.stub.IMyService;

@Service
public class MyService implements IMyService {

    public int sum(int x, int y) {
        return x +y;
    }
}
