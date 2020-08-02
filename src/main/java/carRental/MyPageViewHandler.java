package carRental;

import carRental.config.kafka.KafkaProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class MyPageViewHandler {


    @Autowired
    private MyPageRepository myPageRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenRented_then_CREATE_1 (@Payload Rented rented) {
        try {
            if (rented.isMe()) {
                // view 객체 생성
                MyPage myPage = new MyPage();
                // view 객체에 이벤트의 Value 를 set 함
                myPage.setRentalId(rented.getId());
                myPage.setProdId(rented.getProductId());
                myPage.setFee(rented.getFee());
                myPage.setRentalDate(rented.getRentalDate());
                myPage.setResult(rented.getStatus());
                // view 레파지 토리에 save
                myPageRepository.save(myPage);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @StreamListener(KafkaProcessor.INPUT)
    public void whenPaid_then_UPDATE_1(@Payload Paid paid) {
        try {
            if (paid.isMe()) {
                // view 객체 조회
                List<MyPage> myPageList = myPageRepository.findByRentalId(paid.getRentalId());
                for(MyPage myPage : myPageList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    myPage.setPaymentResult("COMPLETED");
                    // view 레파지 토리에 save
                    myPageRepository.save(myPage);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @StreamListener(KafkaProcessor.INPUT)
    public void whenRefunded_then_DELETE_1(@Payload Refunded refunded) {
        try {
            if (refunded.isMe()) {refunded.setPaymentResult("REFUNDED");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}