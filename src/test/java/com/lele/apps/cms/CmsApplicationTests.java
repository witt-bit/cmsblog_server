package com.lele.apps.cms;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CmsApplicationTests {
    
    
    @Test
    void contextLoads () {
    int count = 0;
        for (int i = 1; i < 5; i++) {
            for (int j = 1; j < 5; j++) {
                for (int k = 1; k < 5; k++) {
                    if(i==j||j==k||i==k)
                        continue;
                    System.out.print(i*100+j*10+k+"\t");
                    count++;
                }
            }
            System.out.println();
        }
    
        System.out.println("总数:"+count);
    }
    
}
