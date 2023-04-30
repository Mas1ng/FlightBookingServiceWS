package com.flight;

import com.flight.mock.MockData;
import com.flight.model.FBS;
import com.flight.repository.FilesOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader {
    FBS fbs = null;
    @Autowired
    public DataLoader() {
        fbs = FilesOperation.loadFBS();
        if(fbs==null) {
            fbs = new FBS();
            //MockData mock = new MockData();
            //mock.generateData(fbs);
        }
    }

    public void run(ApplicationArguments args) throws Exception {
        FilesOperation.storeFBS(fbs);
    }
}
