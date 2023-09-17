package ru.netology.gate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter

public class PaymentGate {

    String id;
    String amount;
    String created;
    String status;
    String transaction_id;

}
