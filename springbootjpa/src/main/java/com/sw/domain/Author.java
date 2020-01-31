package com.sw.domain;

import javax.persistence.*;
import java.util.Date;
@Entity
public class Author {
    @Id
    @GeneratedValue
    private Long id;
    private String nickName;
    private String phone;
    @Temporal(TemporalType.DATE)
    private Date signDate;
    //级联保存persist,级联更新merge,级联查询不需要设置，只需要设置1对1关系
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE,CascadeType.REMOVE},optional = false,fetch = FetchType.EAGER)
    @JoinColumn(name="author_wallet_id")
    private Wallet wallet;

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getSignDate() {
        return signDate;
    }

    public void setSignDate(Date signDate) {
        this.signDate = signDate;
    }


    public Author(){

    }



}
