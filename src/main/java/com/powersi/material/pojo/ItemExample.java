package com.powersi.material.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ItemExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ItemExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andItemClassIdIsNull() {
            addCriterion("item_class_id is null");
            return (Criteria) this;
        }

        public Criteria andItemClassIdIsNotNull() {
            addCriterion("item_class_id is not null");
            return (Criteria) this;
        }

        public Criteria andItemClassIdEqualTo(Integer value) {
            addCriterion("item_class_id =", value, "itemClassId");
            return (Criteria) this;
        }

        public Criteria andItemClassIdNotEqualTo(Integer value) {
            addCriterion("item_class_id <>", value, "itemClassId");
            return (Criteria) this;
        }

        public Criteria andItemClassIdGreaterThan(Integer value) {
            addCriterion("item_class_id >", value, "itemClassId");
            return (Criteria) this;
        }

        public Criteria andItemClassIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("item_class_id >=", value, "itemClassId");
            return (Criteria) this;
        }

        public Criteria andItemClassIdLessThan(Integer value) {
            addCriterion("item_class_id <", value, "itemClassId");
            return (Criteria) this;
        }

        public Criteria andItemClassIdLessThanOrEqualTo(Integer value) {
            addCriterion("item_class_id <=", value, "itemClassId");
            return (Criteria) this;
        }

        public Criteria andItemClassIdIn(List<Integer> values) {
            addCriterion("item_class_id in", values, "itemClassId");
            return (Criteria) this;
        }

        public Criteria andItemClassIdNotIn(List<Integer> values) {
            addCriterion("item_class_id not in", values, "itemClassId");
            return (Criteria) this;
        }

        public Criteria andItemClassIdBetween(Integer value1, Integer value2) {
            addCriterion("item_class_id between", value1, value2, "itemClassId");
            return (Criteria) this;
        }

        public Criteria andItemClassIdNotBetween(Integer value1, Integer value2) {
            addCriterion("item_class_id not between", value1, value2, "itemClassId");
            return (Criteria) this;
        }

        public Criteria andItemCodeIsNull() {
            addCriterion("item_code is null");
            return (Criteria) this;
        }

        public Criteria andItemCodeIsNotNull() {
            addCriterion("item_code is not null");
            return (Criteria) this;
        }

        public Criteria andItemCodeEqualTo(String value) {
            addCriterion("item_code =", value, "itemCode");
            return (Criteria) this;
        }

        public Criteria andItemCodeNotEqualTo(String value) {
            addCriterion("item_code <>", value, "itemCode");
            return (Criteria) this;
        }

        public Criteria andItemCodeGreaterThan(String value) {
            addCriterion("item_code >", value, "itemCode");
            return (Criteria) this;
        }

        public Criteria andItemCodeGreaterThanOrEqualTo(String value) {
            addCriterion("item_code >=", value, "itemCode");
            return (Criteria) this;
        }

        public Criteria andItemCodeLessThan(String value) {
            addCriterion("item_code <", value, "itemCode");
            return (Criteria) this;
        }

        public Criteria andItemCodeLessThanOrEqualTo(String value) {
            addCriterion("item_code <=", value, "itemCode");
            return (Criteria) this;
        }

        public Criteria andItemCodeLike(String value) {
            addCriterion("item_code like", value, "itemCode");
            return (Criteria) this;
        }

        public Criteria andItemCodeNotLike(String value) {
            addCriterion("item_code not like", value, "itemCode");
            return (Criteria) this;
        }

        public Criteria andItemCodeIn(List<String> values) {
            addCriterion("item_code in", values, "itemCode");
            return (Criteria) this;
        }

        public Criteria andItemCodeNotIn(List<String> values) {
            addCriterion("item_code not in", values, "itemCode");
            return (Criteria) this;
        }

        public Criteria andItemCodeBetween(String value1, String value2) {
            addCriterion("item_code between", value1, value2, "itemCode");
            return (Criteria) this;
        }

        public Criteria andItemCodeNotBetween(String value1, String value2) {
            addCriterion("item_code not between", value1, value2, "itemCode");
            return (Criteria) this;
        }

        public Criteria andItemNameIsNull() {
            addCriterion("item_name is null");
            return (Criteria) this;
        }

        public Criteria andItemNameIsNotNull() {
            addCriterion("item_name is not null");
            return (Criteria) this;
        }

        public Criteria andItemNameEqualTo(String value) {
            addCriterion("item_name =", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameNotEqualTo(String value) {
            addCriterion("item_name <>", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameGreaterThan(String value) {
            addCriterion("item_name >", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameGreaterThanOrEqualTo(String value) {
            addCriterion("item_name >=", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameLessThan(String value) {
            addCriterion("item_name <", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameLessThanOrEqualTo(String value) {
            addCriterion("item_name <=", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameLike(String value) {
            addCriterion("item_name like", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameNotLike(String value) {
            addCriterion("item_name not like", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameIn(List<String> values) {
            addCriterion("item_name in", values, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameNotIn(List<String> values) {
            addCriterion("item_name not in", values, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameBetween(String value1, String value2) {
            addCriterion("item_name between", value1, value2, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameNotBetween(String value1, String value2) {
            addCriterion("item_name not between", value1, value2, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemSpellIsNull() {
            addCriterion("item_spell is null");
            return (Criteria) this;
        }

        public Criteria andItemSpellIsNotNull() {
            addCriterion("item_spell is not null");
            return (Criteria) this;
        }

        public Criteria andItemSpellEqualTo(String value) {
            addCriterion("item_spell =", value, "itemSpell");
            return (Criteria) this;
        }

        public Criteria andItemSpellNotEqualTo(String value) {
            addCriterion("item_spell <>", value, "itemSpell");
            return (Criteria) this;
        }

        public Criteria andItemSpellGreaterThan(String value) {
            addCriterion("item_spell >", value, "itemSpell");
            return (Criteria) this;
        }

        public Criteria andItemSpellGreaterThanOrEqualTo(String value) {
            addCriterion("item_spell >=", value, "itemSpell");
            return (Criteria) this;
        }

        public Criteria andItemSpellLessThan(String value) {
            addCriterion("item_spell <", value, "itemSpell");
            return (Criteria) this;
        }

        public Criteria andItemSpellLessThanOrEqualTo(String value) {
            addCriterion("item_spell <=", value, "itemSpell");
            return (Criteria) this;
        }

        public Criteria andItemSpellLike(String value) {
            addCriterion("item_spell like", value, "itemSpell");
            return (Criteria) this;
        }

        public Criteria andItemSpellNotLike(String value) {
            addCriterion("item_spell not like", value, "itemSpell");
            return (Criteria) this;
        }

        public Criteria andItemSpellIn(List<String> values) {
            addCriterion("item_spell in", values, "itemSpell");
            return (Criteria) this;
        }

        public Criteria andItemSpellNotIn(List<String> values) {
            addCriterion("item_spell not in", values, "itemSpell");
            return (Criteria) this;
        }

        public Criteria andItemSpellBetween(String value1, String value2) {
            addCriterion("item_spell between", value1, value2, "itemSpell");
            return (Criteria) this;
        }

        public Criteria andItemSpellNotBetween(String value1, String value2) {
            addCriterion("item_spell not between", value1, value2, "itemSpell");
            return (Criteria) this;
        }

        public Criteria andItemWubiIsNull() {
            addCriterion("item_wubi is null");
            return (Criteria) this;
        }

        public Criteria andItemWubiIsNotNull() {
            addCriterion("item_wubi is not null");
            return (Criteria) this;
        }

        public Criteria andItemWubiEqualTo(String value) {
            addCriterion("item_wubi =", value, "itemWubi");
            return (Criteria) this;
        }

        public Criteria andItemWubiNotEqualTo(String value) {
            addCriterion("item_wubi <>", value, "itemWubi");
            return (Criteria) this;
        }

        public Criteria andItemWubiGreaterThan(String value) {
            addCriterion("item_wubi >", value, "itemWubi");
            return (Criteria) this;
        }

        public Criteria andItemWubiGreaterThanOrEqualTo(String value) {
            addCriterion("item_wubi >=", value, "itemWubi");
            return (Criteria) this;
        }

        public Criteria andItemWubiLessThan(String value) {
            addCriterion("item_wubi <", value, "itemWubi");
            return (Criteria) this;
        }

        public Criteria andItemWubiLessThanOrEqualTo(String value) {
            addCriterion("item_wubi <=", value, "itemWubi");
            return (Criteria) this;
        }

        public Criteria andItemWubiLike(String value) {
            addCriterion("item_wubi like", value, "itemWubi");
            return (Criteria) this;
        }

        public Criteria andItemWubiNotLike(String value) {
            addCriterion("item_wubi not like", value, "itemWubi");
            return (Criteria) this;
        }

        public Criteria andItemWubiIn(List<String> values) {
            addCriterion("item_wubi in", values, "itemWubi");
            return (Criteria) this;
        }

        public Criteria andItemWubiNotIn(List<String> values) {
            addCriterion("item_wubi not in", values, "itemWubi");
            return (Criteria) this;
        }

        public Criteria andItemWubiBetween(String value1, String value2) {
            addCriterion("item_wubi between", value1, value2, "itemWubi");
            return (Criteria) this;
        }

        public Criteria andItemWubiNotBetween(String value1, String value2) {
            addCriterion("item_wubi not between", value1, value2, "itemWubi");
            return (Criteria) this;
        }

        public Criteria andItemSpecIsNull() {
            addCriterion("item_spec is null");
            return (Criteria) this;
        }

        public Criteria andItemSpecIsNotNull() {
            addCriterion("item_spec is not null");
            return (Criteria) this;
        }

        public Criteria andItemSpecEqualTo(String value) {
            addCriterion("item_spec =", value, "itemSpec");
            return (Criteria) this;
        }

        public Criteria andItemSpecNotEqualTo(String value) {
            addCriterion("item_spec <>", value, "itemSpec");
            return (Criteria) this;
        }

        public Criteria andItemSpecGreaterThan(String value) {
            addCriterion("item_spec >", value, "itemSpec");
            return (Criteria) this;
        }

        public Criteria andItemSpecGreaterThanOrEqualTo(String value) {
            addCriterion("item_spec >=", value, "itemSpec");
            return (Criteria) this;
        }

        public Criteria andItemSpecLessThan(String value) {
            addCriterion("item_spec <", value, "itemSpec");
            return (Criteria) this;
        }

        public Criteria andItemSpecLessThanOrEqualTo(String value) {
            addCriterion("item_spec <=", value, "itemSpec");
            return (Criteria) this;
        }

        public Criteria andItemSpecLike(String value) {
            addCriterion("item_spec like", value, "itemSpec");
            return (Criteria) this;
        }

        public Criteria andItemSpecNotLike(String value) {
            addCriterion("item_spec not like", value, "itemSpec");
            return (Criteria) this;
        }

        public Criteria andItemSpecIn(List<String> values) {
            addCriterion("item_spec in", values, "itemSpec");
            return (Criteria) this;
        }

        public Criteria andItemSpecNotIn(List<String> values) {
            addCriterion("item_spec not in", values, "itemSpec");
            return (Criteria) this;
        }

        public Criteria andItemSpecBetween(String value1, String value2) {
            addCriterion("item_spec between", value1, value2, "itemSpec");
            return (Criteria) this;
        }

        public Criteria andItemSpecNotBetween(String value1, String value2) {
            addCriterion("item_spec not between", value1, value2, "itemSpec");
            return (Criteria) this;
        }

        public Criteria andItemUnitIsNull() {
            addCriterion("item_unit is null");
            return (Criteria) this;
        }

        public Criteria andItemUnitIsNotNull() {
            addCriterion("item_unit is not null");
            return (Criteria) this;
        }

        public Criteria andItemUnitEqualTo(String value) {
            addCriterion("item_unit =", value, "itemUnit");
            return (Criteria) this;
        }

        public Criteria andItemUnitNotEqualTo(String value) {
            addCriterion("item_unit <>", value, "itemUnit");
            return (Criteria) this;
        }

        public Criteria andItemUnitGreaterThan(String value) {
            addCriterion("item_unit >", value, "itemUnit");
            return (Criteria) this;
        }

        public Criteria andItemUnitGreaterThanOrEqualTo(String value) {
            addCriterion("item_unit >=", value, "itemUnit");
            return (Criteria) this;
        }

        public Criteria andItemUnitLessThan(String value) {
            addCriterion("item_unit <", value, "itemUnit");
            return (Criteria) this;
        }

        public Criteria andItemUnitLessThanOrEqualTo(String value) {
            addCriterion("item_unit <=", value, "itemUnit");
            return (Criteria) this;
        }

        public Criteria andItemUnitLike(String value) {
            addCriterion("item_unit like", value, "itemUnit");
            return (Criteria) this;
        }

        public Criteria andItemUnitNotLike(String value) {
            addCriterion("item_unit not like", value, "itemUnit");
            return (Criteria) this;
        }

        public Criteria andItemUnitIn(List<String> values) {
            addCriterion("item_unit in", values, "itemUnit");
            return (Criteria) this;
        }

        public Criteria andItemUnitNotIn(List<String> values) {
            addCriterion("item_unit not in", values, "itemUnit");
            return (Criteria) this;
        }

        public Criteria andItemUnitBetween(String value1, String value2) {
            addCriterion("item_unit between", value1, value2, "itemUnit");
            return (Criteria) this;
        }

        public Criteria andItemUnitNotBetween(String value1, String value2) {
            addCriterion("item_unit not between", value1, value2, "itemUnit");
            return (Criteria) this;
        }

        public Criteria andItemSalePriceIsNull() {
            addCriterion("item_sale_price is null");
            return (Criteria) this;
        }

        public Criteria andItemSalePriceIsNotNull() {
            addCriterion("item_sale_price is not null");
            return (Criteria) this;
        }

        public Criteria andItemSalePriceEqualTo(BigDecimal value) {
            addCriterion("item_sale_price =", value, "itemSalePrice");
            return (Criteria) this;
        }

        public Criteria andItemSalePriceNotEqualTo(BigDecimal value) {
            addCriterion("item_sale_price <>", value, "itemSalePrice");
            return (Criteria) this;
        }

        public Criteria andItemSalePriceGreaterThan(BigDecimal value) {
            addCriterion("item_sale_price >", value, "itemSalePrice");
            return (Criteria) this;
        }

        public Criteria andItemSalePriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("item_sale_price >=", value, "itemSalePrice");
            return (Criteria) this;
        }

        public Criteria andItemSalePriceLessThan(BigDecimal value) {
            addCriterion("item_sale_price <", value, "itemSalePrice");
            return (Criteria) this;
        }

        public Criteria andItemSalePriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("item_sale_price <=", value, "itemSalePrice");
            return (Criteria) this;
        }

        public Criteria andItemSalePriceIn(List<BigDecimal> values) {
            addCriterion("item_sale_price in", values, "itemSalePrice");
            return (Criteria) this;
        }

        public Criteria andItemSalePriceNotIn(List<BigDecimal> values) {
            addCriterion("item_sale_price not in", values, "itemSalePrice");
            return (Criteria) this;
        }

        public Criteria andItemSalePriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("item_sale_price between", value1, value2, "itemSalePrice");
            return (Criteria) this;
        }

        public Criteria andItemSalePriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("item_sale_price not between", value1, value2, "itemSalePrice");
            return (Criteria) this;
        }

        public Criteria andItemFactoryNameIsNull() {
            addCriterion("item_factory_name is null");
            return (Criteria) this;
        }

        public Criteria andItemFactoryNameIsNotNull() {
            addCriterion("item_factory_name is not null");
            return (Criteria) this;
        }

        public Criteria andItemFactoryNameEqualTo(String value) {
            addCriterion("item_factory_name =", value, "itemFactoryName");
            return (Criteria) this;
        }

        public Criteria andItemFactoryNameNotEqualTo(String value) {
            addCriterion("item_factory_name <>", value, "itemFactoryName");
            return (Criteria) this;
        }

        public Criteria andItemFactoryNameGreaterThan(String value) {
            addCriterion("item_factory_name >", value, "itemFactoryName");
            return (Criteria) this;
        }

        public Criteria andItemFactoryNameGreaterThanOrEqualTo(String value) {
            addCriterion("item_factory_name >=", value, "itemFactoryName");
            return (Criteria) this;
        }

        public Criteria andItemFactoryNameLessThan(String value) {
            addCriterion("item_factory_name <", value, "itemFactoryName");
            return (Criteria) this;
        }

        public Criteria andItemFactoryNameLessThanOrEqualTo(String value) {
            addCriterion("item_factory_name <=", value, "itemFactoryName");
            return (Criteria) this;
        }

        public Criteria andItemFactoryNameLike(String value) {
            addCriterion("item_factory_name like", value, "itemFactoryName");
            return (Criteria) this;
        }

        public Criteria andItemFactoryNameNotLike(String value) {
            addCriterion("item_factory_name not like", value, "itemFactoryName");
            return (Criteria) this;
        }

        public Criteria andItemFactoryNameIn(List<String> values) {
            addCriterion("item_factory_name in", values, "itemFactoryName");
            return (Criteria) this;
        }

        public Criteria andItemFactoryNameNotIn(List<String> values) {
            addCriterion("item_factory_name not in", values, "itemFactoryName");
            return (Criteria) this;
        }

        public Criteria andItemFactoryNameBetween(String value1, String value2) {
            addCriterion("item_factory_name between", value1, value2, "itemFactoryName");
            return (Criteria) this;
        }

        public Criteria andItemFactoryNameNotBetween(String value1, String value2) {
            addCriterion("item_factory_name not between", value1, value2, "itemFactoryName");
            return (Criteria) this;
        }

        public Criteria andItemDiscStateIsNull() {
            addCriterion("item_disc_state is null");
            return (Criteria) this;
        }

        public Criteria andItemDiscStateIsNotNull() {
            addCriterion("item_disc_state is not null");
            return (Criteria) this;
        }

        public Criteria andItemDiscStateEqualTo(Integer value) {
            addCriterion("item_disc_state =", value, "itemDiscState");
            return (Criteria) this;
        }

        public Criteria andItemDiscStateNotEqualTo(Integer value) {
            addCriterion("item_disc_state <>", value, "itemDiscState");
            return (Criteria) this;
        }

        public Criteria andItemDiscStateGreaterThan(Integer value) {
            addCriterion("item_disc_state >", value, "itemDiscState");
            return (Criteria) this;
        }

        public Criteria andItemDiscStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("item_disc_state >=", value, "itemDiscState");
            return (Criteria) this;
        }

        public Criteria andItemDiscStateLessThan(Integer value) {
            addCriterion("item_disc_state <", value, "itemDiscState");
            return (Criteria) this;
        }

        public Criteria andItemDiscStateLessThanOrEqualTo(Integer value) {
            addCriterion("item_disc_state <=", value, "itemDiscState");
            return (Criteria) this;
        }

        public Criteria andItemDiscStateIn(List<Integer> values) {
            addCriterion("item_disc_state in", values, "itemDiscState");
            return (Criteria) this;
        }

        public Criteria andItemDiscStateNotIn(List<Integer> values) {
            addCriterion("item_disc_state not in", values, "itemDiscState");
            return (Criteria) this;
        }

        public Criteria andItemDiscStateBetween(Integer value1, Integer value2) {
            addCriterion("item_disc_state between", value1, value2, "itemDiscState");
            return (Criteria) this;
        }

        public Criteria andItemDiscStateNotBetween(Integer value1, Integer value2) {
            addCriterion("item_disc_state not between", value1, value2, "itemDiscState");
            return (Criteria) this;
        }

        public Criteria andItemLatelyPicIsNull() {
            addCriterion("item_lately_pic is null");
            return (Criteria) this;
        }

        public Criteria andItemLatelyPicIsNotNull() {
            addCriterion("item_lately_pic is not null");
            return (Criteria) this;
        }

        public Criteria andItemLatelyPicEqualTo(BigDecimal value) {
            addCriterion("item_lately_pic =", value, "itemLatelyPic");
            return (Criteria) this;
        }

        public Criteria andItemLatelyPicNotEqualTo(BigDecimal value) {
            addCriterion("item_lately_pic <>", value, "itemLatelyPic");
            return (Criteria) this;
        }

        public Criteria andItemLatelyPicGreaterThan(BigDecimal value) {
            addCriterion("item_lately_pic >", value, "itemLatelyPic");
            return (Criteria) this;
        }

        public Criteria andItemLatelyPicGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("item_lately_pic >=", value, "itemLatelyPic");
            return (Criteria) this;
        }

        public Criteria andItemLatelyPicLessThan(BigDecimal value) {
            addCriterion("item_lately_pic <", value, "itemLatelyPic");
            return (Criteria) this;
        }

        public Criteria andItemLatelyPicLessThanOrEqualTo(BigDecimal value) {
            addCriterion("item_lately_pic <=", value, "itemLatelyPic");
            return (Criteria) this;
        }

        public Criteria andItemLatelyPicIn(List<BigDecimal> values) {
            addCriterion("item_lately_pic in", values, "itemLatelyPic");
            return (Criteria) this;
        }

        public Criteria andItemLatelyPicNotIn(List<BigDecimal> values) {
            addCriterion("item_lately_pic not in", values, "itemLatelyPic");
            return (Criteria) this;
        }

        public Criteria andItemLatelyPicBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("item_lately_pic between", value1, value2, "itemLatelyPic");
            return (Criteria) this;
        }

        public Criteria andItemLatelyPicNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("item_lately_pic not between", value1, value2, "itemLatelyPic");
            return (Criteria) this;
        }

        public Criteria andItemAverPicIsNull() {
            addCriterion("item_aver_pic is null");
            return (Criteria) this;
        }

        public Criteria andItemAverPicIsNotNull() {
            addCriterion("item_aver_pic is not null");
            return (Criteria) this;
        }

        public Criteria andItemAverPicEqualTo(BigDecimal value) {
            addCriterion("item_aver_pic =", value, "itemAverPic");
            return (Criteria) this;
        }

        public Criteria andItemAverPicNotEqualTo(BigDecimal value) {
            addCriterion("item_aver_pic <>", value, "itemAverPic");
            return (Criteria) this;
        }

        public Criteria andItemAverPicGreaterThan(BigDecimal value) {
            addCriterion("item_aver_pic >", value, "itemAverPic");
            return (Criteria) this;
        }

        public Criteria andItemAverPicGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("item_aver_pic >=", value, "itemAverPic");
            return (Criteria) this;
        }

        public Criteria andItemAverPicLessThan(BigDecimal value) {
            addCriterion("item_aver_pic <", value, "itemAverPic");
            return (Criteria) this;
        }

        public Criteria andItemAverPicLessThanOrEqualTo(BigDecimal value) {
            addCriterion("item_aver_pic <=", value, "itemAverPic");
            return (Criteria) this;
        }

        public Criteria andItemAverPicIn(List<BigDecimal> values) {
            addCriterion("item_aver_pic in", values, "itemAverPic");
            return (Criteria) this;
        }

        public Criteria andItemAverPicNotIn(List<BigDecimal> values) {
            addCriterion("item_aver_pic not in", values, "itemAverPic");
            return (Criteria) this;
        }

        public Criteria andItemAverPicBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("item_aver_pic between", value1, value2, "itemAverPic");
            return (Criteria) this;
        }

        public Criteria andItemAverPicNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("item_aver_pic not between", value1, value2, "itemAverPic");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}