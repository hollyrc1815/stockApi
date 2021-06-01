package com.stocks.api.model;


import javax.persistence.*;

@Entity
@Table(name = "stocks")
public class Stock {

    private String id;
    private String name;
    private String ceo;
    private String price;
    private String stockexchange;
    private String turnover;
    private String website;

    public Stock() {
    }

    public Stock(String id, String name, String ceo, String price, String stockexchange, String turnover, String website) {
        this.id = id;
        this.name = name;
        this.ceo = ceo;
        this.price = price;
        this.stockexchange = stockexchange;
        this.turnover = turnover;
        this.website = website;
    }

    @Id
    @Column(name = "id", nullable = false)
//    @GeneratedValue(strategy = GenerationType.AUTO)
    public String getId() {
        return id;
    }

    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }

    @Column(name = "ceo", nullable = false)
    public String getCeo() {
        return ceo;
    }

    @Column(name = "price", nullable = false)
    public String getPrice() {
        return price;
    }

    @Column(name = "stockexchange", nullable = false)
    public String getStockexchange() {
        return stockexchange;
    }

    @Column(name = "turnover", nullable = false)
    public String getTurnover() {
        return turnover;
    }

    @Column(name = "website", nullable = false)
    public String getWebsite() {
        return website;
    }

    public void setId(String id) { this.id = id; }
    public void setName(String name) {
        this.name = name;
    }
    public void setCeo(String ceo) {
        this.ceo = ceo;
    }
    public void setPrice(String price) {
        this.price = price;
    }
    public void setStockexchange(String stockexchange) {
        this.stockexchange = stockexchange;
    }
    public void setTurnover(String turnover) {
        this.turnover = turnover;
    }
    public void setWebsite(String website) {
        this.website = website;
    }

    @Override
    public String toString() {
        return "Stock [id=" + id + ", nameame=" + name + ", ceo=" + ceo + ", website=" + website + "]";
    }

}
