package com.powersi.material.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ReceiveDetailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ReceiveDetailExample() {
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

        public Criteria andReceIdIsNull() {
            addCriterion("rece_id is null");
            return (Criteria) this;
        }

        public Criteria andReceIdIsNotNull() {
            addCriterion("rece_id is not null");
            return (Criteria) this;
        }

        public Criteria andReceIdEqualTo(String value) {
            addCriterion("rece_id =", value, "receId");
            return (Criteria) this;
        }

        public Criteria andReceIdNotEqualTo(String value) {
            addCriterion("rece_id <>", value, "receId");
            return (Criteria) this;
        }

        public Criteria andReceIdGreaterThan(String value) {
            addCriterion("rece_id >", value, "receId");
            return (Criteria) this;
        }

        public Criteria andReceIdGreaterThanOrEqualTo(String value) {
            addCriterion("rece_id >=", value, "receId");
            return (Criteria) this;
        }

        public Criteria andReceIdLessThan(String value) {
            addCriterion("rece_id <", value, "receId");
            return (Criteria) this;
        }

        public Criteria andReceIdLessThanOrEqualTo(String value) {
            addCriterion("rece_id <=", value, "receId");
            return (Criteria) this;
        }

        public Criteria andReceIdLike(String value) {
            addCriterion("rece_id like", value, "receId");
            return (Criteria) this;
        }

        public Criteria andReceIdNotLike(String value) {
            addCriterion("rece_id not like", value, "receId");
            return (Criteria) this;
        }

        public Criteria andReceIdIn(List<String> values) {
            addCriterion("rece_id in", values, "receId");
            return (Criteria) this;
        }

        public Criteria andReceIdNotIn(List<String> values) {
            addCriterion("rece_id not in", values, "receId");
            return (Criteria) this;
        }

        public Criteria andReceIdBetween(String value1, String value2) {
            addCriterion("rece_id between", value1, value2, "receId");
            return (Criteria) this;
        }

        public Criteria andReceIdNotBetween(String value1, String value2) {
            addCriterion("rece_id not between", value1, value2, "receId");
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

        public Criteria andReceArriveNumberIsNull() {
            addCriterion("rece_arrive_number is null");
            return (Criteria) this;
        }

        public Criteria andReceArriveNumberIsNotNull() {
            addCriterion("rece_arrive_number is not null");
            return (Criteria) this;
        }

        public Criteria andReceArriveNumberEqualTo(BigDecimal value) {
            addCriterion("rece_arrive_number =", value, "receArriveNumber");
            return (Criteria) this;
        }

        public Criteria andReceArriveNumberNotEqualTo(BigDecimal value) {
            addCriterion("rece_arrive_number <>", value, "receArriveNumber");
            return (Criteria) this;
        }

        public Criteria andReceArriveNumberGreaterThan(BigDecimal value) {
            addCriterion("rece_arrive_number >", value, "receArriveNumber");
            return (Criteria) this;
        }

        public Criteria andReceArriveNumberGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("rece_arrive_number >=", value, "receArriveNumber");
            return (Criteria) this;
        }

        public Criteria andReceArriveNumberLessThan(BigDecimal value) {
            addCriterion("rece_arrive_number <", value, "receArriveNumber");
            return (Criteria) this;
        }

        public Criteria andReceArriveNumberLessThanOrEqualTo(BigDecimal value) {
            addCriterion("rece_arrive_number <=", value, "receArriveNumber");
            return (Criteria) this;
        }

        public Criteria andReceArriveNumberIn(List<BigDecimal> values) {
            addCriterion("rece_arrive_number in", values, "receArriveNumber");
            return (Criteria) this;
        }

        public Criteria andReceArriveNumberNotIn(List<BigDecimal> values) {
            addCriterion("rece_arrive_number not in", values, "receArriveNumber");
            return (Criteria) this;
        }

        public Criteria andReceArriveNumberBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("rece_arrive_number between", value1, value2, "receArriveNumber");
            return (Criteria) this;
        }

        public Criteria andReceArriveNumberNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("rece_arrive_number not between", value1, value2, "receArriveNumber");
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