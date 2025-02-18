package za.ac.cput.domain;

/*
 Online-Shopping-System
 Entity for the Order
 Author: Edvalter da Costa Jamba (220446571)
 Date: 4 April 2022
 Changes Date:3 August 2022
*/


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "orders")
public class Order implements Serializable
{

    @NotNull
    @Id
    @Column(name = "order_id")
    private String orderID;

    @NotNull private String orderDate;
    @NotNull private String orderStatus;
    @NotNull private String customerName;
    @NotNull private String deliveryAddress;
    @NotNull private int contactNumber;
    @NotNull
    @Embedded
    private OrderDetails details;

    //
    protected Order(){ }
    //
    private Order(Builder builder)
    {
        this.orderID = builder.orderID;
        this.orderDate = builder.orderDate;
        this.orderStatus = builder.orderStatus;
        this.customerName=builder.customerName;
        this.deliveryAddress=builder.deliveryAddress;
        this.contactNumber= Integer.parseInt(String.valueOf(builder.contactNumber));
        this.details = builder.details;
    }
    //Getters
    public String getOrderID() {
        return orderID;
    }
    public String getOrderDate() {
        return orderDate;
    }
    public String getOrderStatus() {
        return orderStatus;
    }
    public String getCustomerName() {
        return customerName;
    }
    public String getDeliveryAddress() {
        return deliveryAddress;
    }
    public int getContactNumber() {
        return contactNumber;
    }
    public OrderDetails getDetails(){return details;}

    @Override
    public String toString() {
        return "Order{" +
                "orderID='" + orderID + '\'' +
                ", orderDate='" + orderDate + '\'' +
                ", orderStatus='" + orderStatus + '\'' +
                ", customerName='" + customerName + '\'' +
                ", deliveryAddress='" + deliveryAddress + '\'' +
                ", contactNumber=" + contactNumber + '\'' +
                ", orderDetails=" + details +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;
        Order order = (Order) o;
        return contactNumber == order.contactNumber && Objects.equals(orderID, order.orderID) && Objects.equals(orderDate, order.orderDate) && Objects.equals(orderStatus, order.orderStatus) && Objects.equals(customerName, order.customerName) && Objects.equals(deliveryAddress, order.deliveryAddress) && Objects.equals(details, order.details);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderID, orderDate, orderStatus, customerName, deliveryAddress, contactNumber, details);
    }

    public static class Builder{
        private String orderID;

        private String orderDate;
        private String orderStatus;
        private String customerName;
        private String deliveryAddress;
        private int contactNumber;

        private OrderDetails details;

        public Builder setOrderID(String orderID) {
            this.orderID = orderID;
            return this;
        }

        public Builder setOrderDate(String orderDate) {
            this.orderDate = orderDate;
            return this;

        }

        public Builder setOrderStatus(String orderStatus) {
            this.orderStatus = orderStatus;
            return this;
        }

        public Builder setCustomerName(String customerName) {
            this.customerName = customerName;
            return this;
        }

        public Builder setDeliveryAddress(String deliveryAddress) {
            this.deliveryAddress = deliveryAddress;
            return this;
        }

        public Builder setContactNumber(String contactNumber) {
            this.contactNumber = Integer.parseInt(contactNumber);
            return this;
        }

        public Builder setDetails(OrderDetails details) {
            this.details = details;
            return this;
        }
        //copy method//copy of Order object
        public Order.Builder builder(Order order)
        {
            this.orderID = order.orderID;
            this.orderDate = order.orderDate;
            this.orderStatus = order.orderStatus;
            this.customerName=order.customerName;
            this.deliveryAddress=order.deliveryAddress;
            this.contactNumber= Integer.parseInt(String.valueOf(order.contactNumber));
            this.details = order.details;
            return this;
        }

        public Order build(){
            return new Order(this);
        }


    }



}
