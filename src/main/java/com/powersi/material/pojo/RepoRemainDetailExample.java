package com.powersi.material.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class RepoRemainDetailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RepoRemainDetailExample() {
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

        public Criteria andRepoRemainIdIsNull() {
            addCriterion("repo_remain_id is null");
            return (Criteria) this;
        }

        public Criteria andRepoRemainIdIsNotNull() {
            addCriterion("repo_remain_id is not null");
            return (Criteria) this;
        }

        public Criteria andRepoRemainIdEqualTo(String value) {
            addCriterion("repo_remain_id =", value, "repoRemainId");
            return (Criteria) this;
        }

        public Criteria andRepoRemainIdNotEqualTo(String value) {
            addCriterion("repo_remain_id <>", value, "repoRemainId");
            return (Criteria) this;
        }

        public Criteria andRepoRemainIdGreaterThan(String value) {
            addCriterion("repo_remain_id >", value, "repoRemainId");
            return (Criteria) this;
        }

        public Criteria andRepoRemainIdGreaterThanOrEqualTo(String value) {
            addCriterion("repo_remain_id >=", value, "repoRemainId");
            return (Criteria) this;
        }

        public Criteria andRepoRemainIdLessThan(String value) {
            addCriterion("repo_remain_id <", value, "repoRemainId");
            return (Criteria) this;
        }

        public Criteria andRepoRemainIdLessThanOrEqualTo(String value) {
            addCriterion("repo_remain_id <=", value, "repoRemainId");
            return (Criteria) this;
        }

        public Criteria andRepoRemainIdLike(String value) {
            addCriterion("repo_remain_id like", value, "repoRemainId");
            return (Criteria) this;
        }

        public Criteria andRepoRemainIdNotLike(String value) {
            addCriterion("repo_remain_id not like", value, "repoRemainId");
            return (Criteria) this;
        }

        public Criteria andRepoRemainIdIn(List<String> values) {
            addCriterion("repo_remain_id in", values, "repoRemainId");
            return (Criteria) this;
        }

        public Criteria andRepoRemainIdNotIn(List<String> values) {
            addCriterion("repo_remain_id not in", values, "repoRemainId");
            return (Criteria) this;
        }

        public Criteria andRepoRemainIdBetween(String value1, String value2) {
            addCriterion("repo_remain_id between", value1, value2, "repoRemainId");
            return (Criteria) this;
        }

        public Criteria andRepoRemainIdNotBetween(String value1, String value2) {
            addCriterion("repo_remain_id not between", value1, value2, "repoRemainId");
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

        public Criteria andTimesIsNull() {
            addCriterion("times is null");
            return (Criteria) this;
        }

        public Criteria andTimesIsNotNull() {
            addCriterion("times is not null");
            return (Criteria) this;
        }

        public Criteria andTimesEqualTo(Integer value) {
            addCriterion("times =", value, "times");
            return (Criteria) this;
        }

        public Criteria andTimesNotEqualTo(Integer value) {
            addCriterion("times <>", value, "times");
            return (Criteria) this;
        }

        public Criteria andTimesGreaterThan(Integer value) {
            addCriterion("times >", value, "times");
            return (Criteria) this;
        }

        public Criteria andTimesGreaterThanOrEqualTo(Integer value) {
            addCriterion("times >=", value, "times");
            return (Criteria) this;
        }

        public Criteria andTimesLessThan(Integer value) {
            addCriterion("times <", value, "times");
            return (Criteria) this;
        }

        public Criteria andTimesLessThanOrEqualTo(Integer value) {
            addCriterion("times <=", value, "times");
            return (Criteria) this;
        }

        public Criteria andTimesIn(List<Integer> values) {
            addCriterion("times in", values, "times");
            return (Criteria) this;
        }

        public Criteria andTimesNotIn(List<Integer> values) {
            addCriterion("times not in", values, "times");
            return (Criteria) this;
        }

        public Criteria andTimesBetween(Integer value1, Integer value2) {
            addCriterion("times between", value1, value2, "times");
            return (Criteria) this;
        }

        public Criteria andTimesNotBetween(Integer value1, Integer value2) {
            addCriterion("times not between", value1, value2, "times");
            return (Criteria) this;
        }

        public Criteria andRemainAmountIsNull() {
            addCriterion("remain_amount is null");
            return (Criteria) this;
        }

        public Criteria andRemainAmountIsNotNull() {
            addCriterion("remain_amount is not null");
            return (Criteria) this;
        }

        public Criteria andRemainAmountEqualTo(Integer value) {
            addCriterion("remain_amount =", value, "remainAmount");
            return (Criteria) this;
        }

        public Criteria andRemainAmountNotEqualTo(Integer value) {
            addCriterion("remain_amount <>", value, "remainAmount");
            return (Criteria) this;
        }

        public Criteria andRemainAmountGreaterThan(Integer value) {
            addCriterion("remain_amount >", value, "remainAmount");
            return (Criteria) this;
        }

        public Criteria andRemainAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("remain_amount >=", value, "remainAmount");
            return (Criteria) this;
        }

        public Criteria andRemainAmountLessThan(Integer value) {
            addCriterion("remain_amount <", value, "remainAmount");
            return (Criteria) this;
        }

        public Criteria andRemainAmountLessThanOrEqualTo(Integer value) {
            addCriterion("remain_amount <=", value, "remainAmount");
            return (Criteria) this;
        }

        public Criteria andRemainAmountIn(List<Integer> values) {
            addCriterion("remain_amount in", values, "remainAmount");
            return (Criteria) this;
        }

        public Criteria andRemainAmountNotIn(List<Integer> values) {
            addCriterion("remain_amount not in", values, "remainAmount");
            return (Criteria) this;
        }

        public Criteria andRemainAmountBetween(Integer value1, Integer value2) {
            addCriterion("remain_amount between", value1, value2, "remainAmount");
            return (Criteria) this;
        }

        public Criteria andRemainAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("remain_amount not between", value1, value2, "remainAmount");
            return (Criteria) this;
        }

        public Criteria andRepoRemainInPicIsNull() {
            addCriterion("repo_remain_in_pic is null");
            return (Criteria) this;
        }

        public Criteria andRepoRemainInPicIsNotNull() {
            addCriterion("repo_remain_in_pic is not null");
            return (Criteria) this;
        }

        public Criteria andRepoRemainInPicEqualTo(BigDecimal value) {
            addCriterion("repo_remain_in_pic =", value, "repoRemainInPic");
            return (Criteria) this;
        }

        public Criteria andRepoRemainInPicNotEqualTo(BigDecimal value) {
            addCriterion("repo_remain_in_pic <>", value, "repoRemainInPic");
            return (Criteria) this;
        }

        public Criteria andRepoRemainInPicGreaterThan(BigDecimal value) {
            addCriterion("repo_remain_in_pic >", value, "repoRemainInPic");
            return (Criteria) this;
        }

        public Criteria andRepoRemainInPicGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("repo_remain_in_pic >=", value, "repoRemainInPic");
            return (Criteria) this;
        }

        public Criteria andRepoRemainInPicLessThan(BigDecimal value) {
            addCriterion("repo_remain_in_pic <", value, "repoRemainInPic");
            return (Criteria) this;
        }

        public Criteria andRepoRemainInPicLessThanOrEqualTo(BigDecimal value) {
            addCriterion("repo_remain_in_pic <=", value, "repoRemainInPic");
            return (Criteria) this;
        }

        public Criteria andRepoRemainInPicIn(List<BigDecimal> values) {
            addCriterion("repo_remain_in_pic in", values, "repoRemainInPic");
            return (Criteria) this;
        }

        public Criteria andRepoRemainInPicNotIn(List<BigDecimal> values) {
            addCriterion("repo_remain_in_pic not in", values, "repoRemainInPic");
            return (Criteria) this;
        }

        public Criteria andRepoRemainInPicBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("repo_remain_in_pic between", value1, value2, "repoRemainInPic");
            return (Criteria) this;
        }

        public Criteria andRepoRemainInPicNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("repo_remain_in_pic not between", value1, value2, "repoRemainInPic");
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