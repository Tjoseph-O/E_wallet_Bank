package model;

import java.math.BigDecimal;

public class Account {
    private String name;
    private Integer id;
    private BigDecimal balance;

    public Integer getId(){
        return id;
    }
    public String  getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public  BigDecimal getBalance(){
        return balance;
    }
}
