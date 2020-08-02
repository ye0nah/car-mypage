package carRental;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="MyPage_table")
public class MyPage {

        @Id
        @GeneratedValue(strategy=GenerationType.AUTO)
        private Long id;
        private Long prodId;
        private Integer fee;
        private String result;
        private Long rentalId;
        private Date rentalDate;
        private String paymentResult;


        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }
        public Long getProdId() {
            return prodId;
        }

        public void setProdId(Long prodId) {
            this.prodId = prodId;
        }
        public Integer getFee() {
            return fee;
        }

        public void setFee(Integer fee) {
            this.fee = fee;
        }
        public String getResult() {
            return result;
        }

        public void setResult(String result) {
            this.result = result;
        }
        public Long getRentalId() {
            return rentalId;
        }

        public void setRentalId(Long rentalId) {
            this.rentalId = rentalId;
        }
        public Date getRentalDate() {
            return rentalDate;
        }

        public void setRentalDate(Date rentalDate) {
            this.rentalDate = rentalDate;
        }
        public String getPaymentResult() {
            return paymentResult;
        }

        public void setPaymentResult(String paymentResult) {
            this.paymentResult = paymentResult;
        }

}
