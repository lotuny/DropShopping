package com.jnucst2015.dropshopping.service;

import com.jnucst2015.dropshopping.entity.MvoCommodity;

import java.util.List;

public interface MvoCommodityService
{
    /**
     * Add a mvoCommodity into database.
     * @param mvoCommodity to be added.
     * @return the added mvoCommodity.
     */
    MvoCommodity add(MvoCommodity mvoCommodity);

    /**
     * Get a commodity by id.
     * @param id to be find with.
     * @return the found commodity.
     */
    MvoCommodity getById(Integer id);

    /**
     * Update the given mvoCommodity with newer data.
     * @param mvoCommodity to be modify with.
     * @return the modified mvoCommodity.
     */
    MvoCommodity update(MvoCommodity mvoCommodity);

    /**
     * Get all commodities.
     * @return all commodities as a List.
     */
    List<MvoCommodity> getAll();

    /**
     * Get the commodities from the shop.
     * @param shopId to be get.
     * @return all commodities from the shopId.
     */
    /*List<MvoCommodity> getCommoditiesByCompanyId(Integer shopId);*/

    /**
     * Delete a commodity by id.
     * @param id of the commodity to be deleted.
     */
    void deleteById(Integer id);

    /**
     * Delete commodities by ids.
     * @param ids of the commodities to be deleted.
     */
    void deleteByIds(String ids);

    void up(Integer id);
    void down(Integer id);

    List<MvoCommodity> getRecent(Integer count);
}
