package cinemax_4d;

import Customers.Customer;
import Customers.Customers;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Cinimax4D {
    private Queue<Customer> listCustomerBuyTicket=new LinkedList<>();
    private  byte numbersTicker;

    public Cinimax4D() {
        this.setNumbersTicker((byte) 4);
    }

    public Cinimax4D(byte numbersTicker) {
        this.numbersTicker = numbersTicker;
    }

    public byte getNumbersTicker() {
        return this.numbersTicker;
    }

    public void setNumbersTicker(byte numbersTicker) {
        this.numbersTicker = numbersTicker;
    }

    public void saleTicket(Customer customer){
        if (this.numbersTicker==0){
            System.out.println("da ban het ve" +
                    "\ndanh sach khach hang mua ve");
            showListCustomerBuyTicket();
        }else {
            this.listCustomerBuyTicket.add(customer);
            this.numbersTicker--;
        }
    }
    public void showListCustomerBuyTicket(){
        for (Customer customer : listCustomerBuyTicket) {
            System.out.println(customer.showInFor());
        }
    }

    public static void main(String[] args) {
//        Cinimax4D cinimax4D=new Cinimax4D();
//        List<Customer> list= Customers.showInformationCustomer();
//        for (Customer customer:list){
//            cinimax4D.saleTicket(customer);
//        }
    }
}
