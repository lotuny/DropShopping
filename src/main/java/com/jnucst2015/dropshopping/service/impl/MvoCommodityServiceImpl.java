package com.jnucst2015.dropshopping.service.impl;

import com.jnucst2015.dropshopping.entity.MvoCommodity;
import com.jnucst2015.dropshopping.repository.MvoCommodityRepository;
import com.jnucst2015.dropshopping_test.service.MvoCommodityService;
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
        return re.findById(id).get();
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
     * @param company_id to be get.
     * @return all commodities from the company_id.
     */
    @Override
    public List<MvoCommodity> getCommoditiesByCompanyId(Integer company_id)
    {
        return re.findMvoCommoditiesByCompany_idIs(company_id);
    }

    /**
     * Get the commodity from the company
     *
     * @param id         to be get.
     * @param company_id as a token.
     * @return the specified commodity from the company.
     */
    @Override
    public MvoCommodity getCommoditiesByIdAndCompanyId(Integer id, Integer company_id)
    {
        return re.getMvoCommoditiesByIdIsAndCompany_idIs(id, company_id);
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

    @Override
    public void up(Integer id)
    {
        MvoCommodity commodity = re.findById(id).get();
        commodity.setState(1);
        re.save(commodity);
    }

    @Override
    public void down(Integer id)
    {
        MvoCommodity commodity = re.findById(id).get();
        commodity.setState(0);
        re.save(commodity);
    }

    @Override
    public List<MvoCommodity> getRecent(Integer count)
    {
        return re.getMvoCommoditiesRecently(count);
    }

    @Override
    public List<MvoCommodity> getAllOnSale() {
        return re.getAllByStateEquals(1);
    }
}
