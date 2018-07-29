package com.jnucst2015.dropshopping.repository;

import com.jnucst2015.dropshopping.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

    /**
     *
     * @param payerId
     * @param payerRole
     * @return
     */
    @Query(value = "select t.* from transaction as t where t.payer_id=?1 and t.payer_role=?2", nativeQuery = true)
    List<Transaction> getAllByPayer_idaAndPayer_role(Integer payerId, Integer payerRole);

    /**
     *
     * @param recipientId
     * @param RecipientRole
     * @return
     */
    @Query(value = "select t.* from transaction as t where t.recipient_id=?1 and t.recipient_role=?2", nativeQuery = true)
    List<Transaction> getAllByRecipient_idAndRecipient_role(Integer recipientId, Integer RecipientRole);
}
