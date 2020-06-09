package com.powersi.material.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ItemSaleDetailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ItemSaleDetailExample() {
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

        public Criteria andItemSaleIdIsNull() {
            addCriterion("item_sale_id is null");
            return (Criteria) this;
        }

        public Criteria andItemSaleIdIsNotNull() {
            addCriterion("item_sale_id is not null");
            return (Criteria) this;
        }

        public Criteria andItemSaleIdEqualTo(String value) {
            addCriterion("item_sale_id =", value, "itemSaleId");
            return (Criteria) this;
        }

        public Criteria andItemSaleIdNotEqualTo(String value) {
            addCriterion("item_sale_id <>", value, "itemSaleId");
            return (Criteria) this;
        }

        public Criteria andItemSaleIdGreaterThan(String value) {
            addCriterion("item_sale_id >", value, "itemSaleId");
            return (Criteria) this;
        }

        public Criteria andItemSaleIdGreaterThanOrEqualTo(String value) {
            addCriterion("item_sale_id >=", value, "itemSaleId");
            return (Criteria) this;
        }

        public Criteria andItemSaleIdLessThan(String value) {
            addCriterion("item_sale_id <", value, "itemSaleId");
            return (Criteria) this;
        }

        public Criteria andItemSaleIdLessThanOrEqualTo(String value) {
            addCriterion("item_sale_id <=", value, "itemSaleId");
            return (Criteria) this;
        }

        public Criteria andItemSaleIdLike(String value) {
            addCriterion("item_sale_id like", value, "itemSaleId");
            return (Criteria) this;
        }

        public Criteria andItemSaleIdNotLike(String value) {
            addCriterion("item_sale_id not like", value, "itemSaleId");
            return (Criteria) this;
        }

        public Criteria andItemSaleIdIn(List<String> values) {
            addCriterion("item_sale_id in", values, "itemSaleId");
            return (Criteria) this;
        }

        public Criteria andItemSaleIdNotIn(List<String> values) {
            addCriterion("item_sale_id not in", values, "itemSaleId");
            return (Criteria) this;
        }

        public Criteria andItemSaleIdBetween(String value1, String value2) {
            addCriterion("item_sale_id between", value1, value2, "itemSaleId");
            return (Criteria) this;
        }

        public Criteria andItemSaleIdNotBetween(String value1, String value2) {
            addCriterion("item_sale_id not between", value1, value2, "itemSaleId");
            return (Criteria) this;
        }

        public Criteria andItemIdIsNull() {
            addCriterion("item_id is null");
            return (Criteria) this;
        }

        public Criteria andItemIdIsNotNull() {
            addCriterion("item_id is not null");
            return (Criteria) this;
        }

        public Criteria andItemIdEqualTo(String value) {
            addCriterion("item_id =", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdNotEqualTo(String value) {
            addCriterion("item_id <>", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdGreaterThan(String value) {
            addCriterion("item_id >", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdGreaterThanOrEqualTo(String value) {
            addCriterion("item_id >=", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdLessThan(String value) {
            addCriterion("item_id <", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdLessThanOrEqualTo(String value) {
            addCriterion("item_id <=", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdLike(String value) {
            addCriterion("item_id like", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdNotLike(String value) {
            addCriterion("item_id not like", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdIn(List<String> values) {
            addCriterion("item_id in", values, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdNotIn(List<String> values) {
            addCriterion("item_id not in", values, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdBetween(String value1, String value2) {
            addCriterion("item_id between", value1, value2, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdNotBetween(String value1, String value2) {
            addCriterion("item_id not between", value1, value2, "itemId");
            return (Criteria) this;
        }

        public Criteria andRepoIdIsNull() {
            addCriterion("repo_id is null");
            return (Criteria) this;
        }

        public Criteria andRepoIdIsNotNull() {
            addCriterion("repo_id is not null");
            return (Criteria) this;
        }

        public Criteria andRepoIdEqualTo(String value) {
            addCriterion("repo_id =", value, "repoId");
            return (Criteria) this;
        }

        public Criteria andRepoIdNotEqualTo(String value) {
            addCriterion("repo_id <>", value, "repoId");
            return (Criteria) this;
        }

        public Criteria andRepoIdGreaterThan(String value) {
            addCriterion("repo_id >", value, "repoId");
            return (Criteria) this;
        }

        public Criteria andRepoIdGreaterThanOrEqualTo(String value) {
            addCriterion("repo_id >=", value, "repoId");
            return (Criteria) this;
        }

        public Criteria andRepoIdLessThan(String value) {
            addCriterion("repo_id <", value, "repoId");
            return (Criteria) this;
        }

        public Criteria andRepoIdLessThanOrEqualTo(String value) {
            addCriterion("repo_id <=", value, "repoId");
            return (Criteria) this;
        }

        public Criteria andRepoIdLike(String value) {
            addCriterion("repo_id like", value, "repoId");
            return (Criteria) this;
        }

        public Criteria andRepoIdNotLike(String value) {
            addCriterion("repo_id not like", value, "repoId");
            return (Criteria) this;
        }

        public Criteria andRepoIdIn(List<String> values) {
            addCriterion("repo_id in", values, "repoId");
            return (Criteria) this;
        }

        public Criteria andRepoIdNotIn(List<String> values) {
            addCriterion("repo_id not in", values, "repoId");
            return (Criteria) this;
        }

        public Criteria andRepoIdBetween(String value1, String value2) {
            addCriterion("repo_id between", value1, value2, "repoId");
            return (Criteria) this;
        }

        public Criteria andRepoIdNotBetween(String value1, String value2) {
            addCriterion("repo_id not between", value1, value2, "repoId");
            return (Criteria) this;
        }

        public Criteria andSupplierIdIsNull() {
            addCriterion("supplier_id is null");
            return (Criteria) this;
        }

        public Criteria andSupplierIdIsNotNull() {
            addCriterion("supplier_id is not null");
            return (Criteria) this;
        }

        public Criteria andSupplierIdEqualTo(String value) {
            addCriterion("supplier_id =", value, "supplierId");
            return (Criteria) this;
        }

        public Criteria andSupplierIdNotEqualTo(String value) {
            addCriterion("supplier_id <>", value, "supplierId");
            return (Criteria) this;
        }

        public Criteria andSupplierIdGreaterThan(String value) {
            addCriterion("supplier_id >", value, "supplierId");
            return (Criteria) this;
        }

        public Criteria andSupplierIdGreaterThanOrEqualTo(String value) {
            addCriterion("supplier_id >=", value, "supplierId");
            return (Criteria) this;
        }

        public Criteria andSupplierIdLessThan(String value) {
            addCriterion("supplier_id <", value, "supplierId");
            return (Criteria) this;
        }

        public Criteria andSupplierIdLessThanOrEqualTo(String value) {
            addCriterion("supplier_id <=", value, "supplierId");
            return (Criteria) this;
        }

        public Criteria andSupplierIdLike(String value) {
            addCriterion("supplier_id like", value, "supplierId");
            return (Criteria) this;
        }

        public Criteria andSupplierIdNotLike(String value) {
            addCriterion("supplier_id not like", value, "supplierId");
            return (Criteria) this;
        }

        public Criteria andSupplierIdIn(List<String> values) {
            addCriterion("supplier_id in", values, "supplierId");
            return (Criteria) this;
        }

        public Criteria andSupplierIdNotIn(List<String> values) {
            addCriterion("supplier_id not in", values, "supplierId");
            return (Criteria) this;
        }

        public Criteria andSupplierIdBetween(String value1, String value2) {
            addCriterion("supplier_id between", value1, value2, "supplierId");
            return (Criteria) this;
        }

        public Criteria andSupplierIdNotBetween(String value1, String value2) {
            addCriterion("supplier_id not between", value1, value2, "supplierId");
            return (Criteria) this;
        }

        public Criteria andSalePriceIsNull() {
            addCriterion("sale_price is null");
            return (Criteria) this;
        }

        public Criteria andSalePriceIsNotNull() {
            addCriterion("sale_price is not null");
            return (Criteria) this;
        }

        public Criteria andSalePriceEqualTo(BigDecimal value) {
            addCriterion("sale_price =", value, "salePrice");
            return (Criteria) this;
        }

        public Criteria andSalePriceNotEqualTo(BigDecimal value) {
            addCriterion("sale_price <>", value, "salePrice");
            return (Criteria) this;
        }

        public Criteria andSalePriceGreaterThan(BigDecimal value) {
            addCriterion("sale_price >", value, "salePrice");
            return (Criteria) this;
        }

        public Criteria andSalePriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("sale_price >=", value, "salePrice");
            return (Criteria) this;
        }

        public Criteria andSalePriceLessThan(BigDecimal value) {
            addCriterion("sale_price <", value, "salePrice");
            return (Criteria) this;
        }

        public Criteria andSalePriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("sale_price <=", value, "salePrice");
            return (Criteria) this;
        }

        public Criteria andSalePriceIn(List<BigDecimal> values) {
            addCriterion("sale_price in", values, "salePrice");
            return (Criteria) this;
        }

        public Criteria andSalePriceNotIn(List<BigDecimal> values) {
            addCriterion("sale_price not in", values, "salePrice");
            return (Criteria) this;
        }

        public Criteria andSalePriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("sale_price between", value1, value2, "salePrice");
            return (Criteria) this;
        }

        public Criteria andSalePriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("sale_price not between", value1, value2, "salePrice");
            return (Criteria) this;
        }

        public Criteria andSaleNumberIsNull() {
            addCriterion("sale_number is null");
            return (Criteria) this;
        }

        public Criteria andSaleNumberIsNotNull() {
            addCriterion("sale_number is not null");
            return (Criteria) this;
        }

        public Criteria andSaleNumberEqualTo(Long value) {
            addCriterion("sale_number =", value, "saleNumber");
            return (Criteria) this;
        }

        public Criteria andSaleNumberNotEqualTo(Long value) {
            addCriterion("sale_number <>", value, "saleNumber");
            return (Criteria) this;
        }

        public Criteria andSaleNumberGreaterThan(Long value) {
            addCriterion("sale_number >", value, "saleNumber");
            return (Criteria) this;
        }

        public Criteria andSaleNumberGreaterThanOrEqualTo(Long value) {
            addCriterion("sale_number >=", value, "saleNumber");
            return (Criteria) this;
        }

        public Criteria andSaleNumberLessThan(Long value) {
            addCriterion("sale_number <", value, "saleNumber");
            return (Criteria) this;
        }

        public Criteria andSaleNumberLessThanOrEqualTo(Long value) {
            addCriterion("sale_number <=", value, "saleNumber");
            return (Criteria) this;
        }

        public Criteria andSaleNumberIn(List<Long> values) {
            addCriterion("sale_number in", values, "saleNumber");
            return (Criteria) this;
        }

        public Criteria andSaleNumberNotIn(List<Long> values) {
            addCriterion("sale_number not in", values, "saleNumber");
            return (Criteria) this;
        }

        public Criteria andSaleNumberBetween(Long value1, Long value2) {
            addCriterion("sale_number between", value1, value2, "saleNumber");
            return (Criteria) this;
        }

        public Criteria andSaleNumberNotBetween(Long value1, Long value2) {
            addCriterion("sale_number not between", value1, value2, "saleNumber");
            return (Criteria) this;
        }

        public Criteria andSaleAfterDiscountIsNull() {
            addCriterion("sale_after_discount is null");
            return (Criteria) this;
        }

        public Criteria andSaleAfterDiscountIsNotNull() {
            addCriterion("sale_after_discount is not null");
            return (Criteria) this;
        }

        public Criteria andSaleAfterDiscountEqualTo(BigDecimal value) {
            addCriterion("sale_after_discount =", value, "saleAfterDiscount");
            return (Criteria) this;
        }

        public Criteria andSaleAfterDiscountNotEqualTo(BigDecimal value) {
            addCriterion("sale_after_discount <>", value, "saleAfterDiscount");
            return (Criteria) this;
        }

        public Criteria andSaleAfterDiscountGreaterThan(BigDecimal value) {
            addCriterion("sale_after_discount >", value, "saleAfterDiscount");
            return (Criteria) this;
        }

        public Criteria andSaleAfterDiscountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("sale_after_discount >=", value, "saleAfterDiscount");
            return (Criteria) this;
        }

        public Criteria andSaleAfterDiscountLessThan(BigDecimal value) {
            addCriterion("sale_after_discount <", value, "saleAfterDiscount");
            return (Criteria) this;
        }

        public Criteria andSaleAfterDiscountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("sale_after_discount <=", value, "saleAfterDiscount");
            return (Criteria) this;
        }

        public Criteria andSaleAfterDiscountIn(List<BigDecimal> values) {
            addCriterion("sale_after_discount in", values, "saleAfterDiscount");
            return (Criteria) this;
        }

        public Criteria andSaleAfterDiscountNotIn(List<BigDecimal> values) {
            addCriterion("sale_after_discount not in", values, "saleAfterDiscount");
            return (Criteria) this;
        }

        public Criteria andSaleAfterDiscountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("sale_after_discount between", value1, value2, "saleAfterDiscount");
            return (Criteria) this;
        }

        public Criteria andSaleAfterDiscountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("sale_after_discount not between", value1, value2, "saleAfterDiscount");
            return (Criteria) this;
        }

        public Criteria andSaleDiscountAmountIsNull() {
            addCriterion("sale_discount_amount is null");
            return (Criteria) this;
        }

        public Criteria andSaleDiscountAmountIsNotNull() {
            addCriterion("sale_discount_amount is not null");
            return (Criteria) this;
        }

        public Criteria andSaleDiscountAmountEqualTo(BigDecimal value) {
            addCriterion("sale_discount_amount =", value, "saleDiscountAmount");
            return (Criteria) this;
        }

        public Criteria andSaleDiscountAmountNotEqualTo(BigDecimal value) {
            addCriterion("sale_discount_amount <>", value, "saleDiscountAmount");
            return (Criteria) this;
        }

        public Criteria andSaleDiscountAmountGreaterThan(BigDecimal value) {
            addCriterion("sale_discount_amount >", value, "saleDiscountAmount");
            return (Criteria) this;
        }

        public Criteria andSaleDiscountAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("sale_discount_amount >=", value, "saleDiscountAmount");
            return (Criteria) this;
        }

        public Criteria andSaleDiscountAmountLessThan(BigDecimal value) {
            addCriterion("sale_discount_amount <", value, "saleDiscountAmount");
            return (Criteria) this;
        }

        public Criteria andSaleDiscountAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("sale_discount_amount <=", value, "saleDiscountAmount");
            return (Criteria) this;
        }

        public Criteria andSaleDiscountAmountIn(List<BigDecimal> values) {
            addCriterion("sale_discount_amount in", values, "saleDiscountAmount");
            return (Criteria) this;
        }

        public Criteria andSaleDiscountAmountNotIn(List<BigDecimal> values) {
            addCriterion("sale_discount_amount not in", values, "saleDiscountAmount");
            return (Criteria) this;
        }

        public Criteria andSaleDiscountAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("sale_discount_amount between", value1, value2, "saleDiscountAmount");
            return (Criteria) this;
        }

        public Criteria andSaleDiscountAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("sale_discount_amount not between", value1, value2, "saleDiscountAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountIsNull() {
            addCriterion("total_amount is null");
            return (Criteria) this;
        }

        public Criteria andTotalAmountIsNotNull() {
            addCriterion("total_amount is not null");
            return (Criteria) this;
        }

        public Criteria andTotalAmountEqualTo(BigDecimal value) {
            addCriterion("total_amount =", value, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountNotEqualTo(BigDecimal value) {
            addCriterion("total_amount <>", value, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountGreaterThan(BigDecimal value) {
            addCriterion("total_amount >", value, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("total_amount >=", value, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountLessThan(BigDecimal value) {
            addCriterion("total_amount <", value, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("total_amount <=", value, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountIn(List<BigDecimal> values) {
            addCriterion("total_amount in", values, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountNotIn(List<BigDecimal> values) {
            addCriterion("total_amount not in", values, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_amount between", value1, value2, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_amount not between", value1, value2, "totalAmount");
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