package Entities;

import Entities.Invoice;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-10-18T00:10:51")
@StaticMetamodel(Customer.class)
public class Customer_ { 

    public static volatile CollectionAttribute<Customer, Invoice> invoiceCollection;
    public static volatile SingularAttribute<Customer, String> address;
    public static volatile SingularAttribute<Customer, Integer> phone;
    public static volatile SingularAttribute<Customer, String> name;
    public static volatile SingularAttribute<Customer, Integer> discount;
    public static volatile SingularAttribute<Customer, Integer> id;
    public static volatile SingularAttribute<Customer, String> email;
    public static volatile SingularAttribute<Customer, Boolean> loyaltycard;

}