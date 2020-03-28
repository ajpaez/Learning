package com.apr.learning.hibernate.repository;

import com.apr.learning.hibernate.HibernateApplication;
import com.apr.learning.hibernate.entity.Checkout;
import com.apr.learning.hibernate.entity.CheckoutDetailAttendance;
import com.apr.learning.hibernate.entity.CheckoutDetailProduct;
import com.apr.learning.hibernate.entity.Product;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.transaction.TestTransaction;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationAdapter;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = HibernateApplication.class)
@TestMethodOrder(MethodOrderer.Alphanumeric.class)
class CheckoutRepositoryTest {

    @Autowired
    CheckoutRepository checkoutRepository;
    @Autowired
    CheckoutDetailsAttendanceRepository checkoutDetailsAttendanceRepository;
    @Autowired
    CheckoutDetailsProductRepository checkoutDetailsProductRepository;
    @Autowired
    ProductRepository productRepository;

    @Test
    @DirtiesContext
    @Transactional
    void addACheckout() {

        Product product = new Product();
        product.setName("product1");
        Product productSaved = productRepository.save(product);

        CheckoutDetailProduct checkoutDetailProduct = new CheckoutDetailProduct();
        checkoutDetailProduct.setAmount(1);
        checkoutDetailProduct.setProduct(product);
        CheckoutDetailAttendance checkoutDetailAttendance = new CheckoutDetailAttendance();
        checkoutDetailAttendance.setAmount(1);
        checkoutDetailAttendance.setIdAttendance(60L);

        Checkout checkout = new Checkout();
        checkout.setIdCustomer(2L);
        checkout.addProductDetail(checkoutDetailProduct);
        checkout.addAttendanceDetail(checkoutDetailAttendance);

        checkoutRepository.save(checkout);

        List<Checkout> checkouts = checkoutRepository.findAll();

        assertTrue(checkouts.size() == 1);
        assertTrue(checkoutDetailsAttendanceRepository.findAllByCheckout(checkouts.get(0)).size() == 1);
        assertTrue(checkoutDetailsProductRepository.findAllByCheckout(checkouts.get(0)).size() == 1);

        assertTrue(checkoutDetailsProductRepository.findByCheckout(checkouts.get(0)).getProduct().getId() == productSaved.getId());


        checkoutRepository.delete(checkout);
        checkouts = checkoutRepository.findAll();

        assertTrue(checkouts.size() == 0);
        assertTrue(checkoutDetailsAttendanceRepository.findAllByCheckout(checkout).size() == 0);
        assertTrue(checkoutDetailsProductRepository.findAllByCheckout(checkout).size() == 0);
        assertTrue(productRepository.count() == 1);

    }

    @Test
    @DirtiesContext
    @Transactional
    void addACheckoutWithNonExistentProduct() {

        Product product = new Product();
        product.setName("product1");
        //Product productSaved = productRepository.save(product); --> don't save the product

        CheckoutDetailProduct checkoutDetailProduct = new CheckoutDetailProduct();
        checkoutDetailProduct.setAmount(1);
        checkoutDetailProduct.setProduct(product);

        Checkout checkout = new Checkout();
        checkout.setIdCustomer(2L);
        checkout.addProductDetail(checkoutDetailProduct);

        assertThrows(InvalidDataAccessApiUsageException.class, () -> checkoutRepository.save(checkout));
        TestTransaction.end();
        assertTrue(checkoutRepository.count() == 0);
        assertTrue(checkoutDetailsAttendanceRepository.count() == 0);
        assertTrue(checkoutDetailsProductRepository.count() == 0);
        assertTrue(productRepository.count() == 0);

    }

    @Test
    @DirtiesContext
    @Transactional
    void removeCheckoutWithTwoAttendances() {
        CheckoutDetailAttendance checkoutDetailAttendance1 = new CheckoutDetailAttendance();
        checkoutDetailAttendance1.setAmount(1);
        checkoutDetailAttendance1.setIdAttendance(60L);
        CheckoutDetailAttendance checkoutDetailAttendance2 = new CheckoutDetailAttendance();
        checkoutDetailAttendance2.setAmount(10);
        checkoutDetailAttendance2.setIdAttendance(50L);


        Checkout checkout = new Checkout();
        checkout.setIdCustomer(2L);
        checkout.addAttendanceDetail(checkoutDetailAttendance2);
        checkout.addAttendanceDetail(checkoutDetailAttendance1);

        checkoutRepository.save(checkout);

        List<Checkout> checkouts = checkoutRepository.findAll();

        assertTrue(checkouts.size() == 1);
        assertTrue(checkoutDetailsAttendanceRepository.findAllByCheckout(checkouts.get(0)).size() == 2);
        assertTrue(checkoutDetailsProductRepository.findAllByCheckout(checkouts.get(0)).size() == 0);

        checkoutRepository.delete(checkout);
        checkouts = checkoutRepository.findAll();

        assertTrue(checkouts.size() == 0);
        assertTrue(checkoutDetailsAttendanceRepository.findAllByCheckout(checkout).size() == 0);
        assertTrue(checkoutDetailsProductRepository.findAllByCheckout(checkout).size() == 0);

    }


}
