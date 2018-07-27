package com.jnucst2015.dropshopping.service.impl;

import com.jnucst2015.dropshopping.entity.MvoCommodity;
import com.jnucst2015.dropshopping.repository.MvoCommodityRepository;
import com.jnucst2015.dropshopping.service.MvoCommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class MvoCommodityServiceImpl implements MvoCommodityService
{
    @Autowired
    private MvoCommodityRepository re;

    /**
     * Add a mvoCommodity into database.
     *
     * @param mvoCommodity to be added.
     * @return the added mvoCommodity.
     */
    @Override
    public MvoCommodity add(MvoCommodity mvoCommodity)
    {
        return re.save(mvoCommodity);
    }

    /**
     * Get a commodity by id.
     *
     * @param id to be find with.
     * @return the found commodity.
     */
    @Override
    public MvoCommodity getById(Integer id)
    {
        return re.getOne(id);
    }

    /**
     * Update the given mvoCommodity with newer data.
     *
     * @param mvoCommodity to be modify with.
     * @return the modified mvoCommodity.
     */
    @Override
    public MvoCommodity update(MvoCommodity mvoCommodity)
    {
        return re.save(mvoCommodity);
    }

    /**
     * Get all commodities.
     *
     * @return all commodities as a List.
     */
    @Override
    public List<MvoCommodity> getAll()
    {
        return re.findAll();
    }

    /**
     * Get the commodities from the shop.
     *
     * @param shopId to be get.
     * @return all commodities from the shopId.
     */
    @Override
    public List<MvoCommodity> getCommoditiesByShopId(Integer shopId)
    {
        return re.getCommoditiesByShop_idIs(shopId);
    }

    /**
     * Delete a commodity by id.
     *
     * @param id of the commodity to be deleted.
     */
    @Override
    public void deleteById(Integer id)
    {
        re.deleteById(id);
    }

    /**
     * Delete commodities by ids.
     *
     * @param ids of the commodities to be deleted.
     */
    @Override
    public void deleteByIds(String ids)
    {
        Arrays.asList(ids.split(",")).forEach(s -> deleteById(Integer.parseInt(s)));
    }
}
