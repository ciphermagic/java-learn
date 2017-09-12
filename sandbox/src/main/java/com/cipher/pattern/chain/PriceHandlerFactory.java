package com.cipher.pattern.chain;

/**
 * Created by cipher on 2017/9/12.
 */
public class PriceHandlerFactory {

    /**
     * 创建 PriceHandlerFactory 的工厂方法
     *
     * @return
     */
    public static PriceHandler createPriceHandler() {
        PriceHandler ceo = new CEO();
        PriceHandler vp = new VicePresident();
        PriceHandler director = new Director();
        PriceHandler manager = new Manager();
        PriceHandler lead = new Lead();
        PriceHandler sales = new Sales();

        sales.setSuccessor(lead);
        lead.setSuccessor(manager);
        manager.setSuccessor(director);
        director.setSuccessor(vp);
        vp.setSuccessor(ceo);

        return sales;
    }

}
