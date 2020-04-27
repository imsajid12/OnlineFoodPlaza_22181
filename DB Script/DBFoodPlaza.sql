
CREATE DATABASE FoodPlaza_22181;

use FoodPlaza_22181;

show tables;

/*Create table cart*/
CREATE TABLE Cart(cartId int auto_increment primary key, foodId int, customerEmail varchar(50), quantity int);

/*Create table customer*/
CREATE TABLE Customer(customerId int auto_increment primary key, customerName varchar(50), customerEmail varchar(50),
customerPassword varchar(50), customerContact varchar(50), customerAddress varchar(100));

/*Create table food*/
CREATE TABLE Food(foodId int auto_increment primary key, foodName varchar(50), foodCategory varchar(50),
foodPrice double);

/*Create table orders*/
CREATE TABLE Orders(orderId int auto_increment primary key, totalPrice double, customerEmail varchar(50),
orderStatus varchar(50), orderDate varchar(50));

desc Food;