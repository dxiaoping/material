package com.powersi.material.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ItemSaleExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ItemSaleExample() {
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

        public Criteria andMemberIdIsNull() {
            addCriterion("member_id is null");
            return (Criteria) this;
        }

        public Criteria andMemberIdIsNotNull() {
            addCriterion("member_id is not null");
            return (Criteria) this;
        }

        public Criteria andMemberIdEqualTo(String value) {
            addCriterion("member_id =", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdNotEqualTo(String value) {
            addCriterion("member_id <>", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdGreaterThan(String value) {
            addCriterion("member_id >", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdGreaterThanOrEqualTo(String value) {
            addCriterion("member_id >=", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdLessThan(String value) {
            addCriterion("member_id <", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdLessThanOrEqualTo(String value) {
            addCriterion("member_id <=", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdLike(String value) {
            addCriterion("member_id like", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdNotLike(String value) {
            addCriterion("member_id not like", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdIn(List<String> values) {
            addCriterion("member_id in", values, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdNotIn(List<String> values) {
            addCriterion("member_id not in", values, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdBetween(String value1, String value2) {
            addCriterion("member_id between", value1, value2, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdNotBetween(String value1, String value2) {
            addCriterion("member_id not between", value1, value2, "memberId");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdIsNull() {
            addCriterion("employee_id is null");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdIsNotNull() {
            addCriterion("employee_id is not null");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdEqualTo(String value) {
            addCriterion("employee_id =", value, "employeeId");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdNotEqualTo(String value) {
            addCriterion("employee_id <>", value, "employeeId");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdGreaterThan(String value) {
            addCriterion("employee_id >", value, "employeeId");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdGreaterThanOrEqualTo(String value) {
            addCriterion("employee_id >=", value, "employeeId");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdLessThan(String value) {
            addCriterion("employee_id <", value, "employeeId");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdLessThanOrEqualTo(String value) {
            addCriterion("employee_id <=", value, "employeeId");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdLike(String value) {
            addCriterion("employee_id like", value, "employeeId");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdNotLike(String value) {
            addCriterion("employee_id not like", value, "employeeId");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdIn(List<String> values) {
            addCriterion("employee_id in", values, "employeeId");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdNotIn(List<String> values) {
            addCriterion("employee_id not in", values, "employeeId");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdBetween(String value1, String value2) {
            addCriterion("employee_id between", value1, value2, "employeeId");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdNotBetween(String value1, String value2) {
            addCriterion("employee_id not between", value1, value2, "employeeId");
            return (Criteria) this;
        }

        public Criteria andSaleTimeIsNull() {
            addCriterion("sale_time is null");
            return (Criteria) this;
        }

        public Criteria andSaleTimeIsNotNull() {
            addCriterion("sale_time is not null");
            return (Criteria) this;
        }

        public Criteria andSaleTimeEqualTo(Date value) {
            addCriterion("sale_time =", value, "saleTime");
            return (Criteria) this;
        }

        public Criteria andSaleTimeNotEqualTo(Date value) {
            addCriterion("sale_time <>", value, "saleTime");
            return (Criteria) this;
        }

        public Criteria andSaleTimeGreaterThan(Date value) {
            addCriterion("sale_time >", value, "saleTime");
            return (Criteria) this;
        }

        public Criteria andSaleTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("sale_time >=", value, "saleTime");
            return (Criteria) this;
        }

        public Criteria andSaleTimeLessThan(Date value) {
            addCriterion("sale_time <", value, "saleTime");
            return (Criteria) this;
        }

        public Criteria andSaleTimeLessThanOrEqualTo(Date value) {
            addCriterion("sale_time <=", value, "saleTime");
            return (Criteria) this;
        }

        public Criteria andSaleTimeIn(List<Date> values) {
            addCriterion("sale_time in", values, "saleTime");
            return (Criteria) this;
        }

        public Criteria andSaleTimeNotIn(List<Date> values) {
            addCriterion("sale_time not in", values, "saleTime");
            return (Criteria) this;
        }

        public Criteria andSaleTimeBetween(Date value1, Date value2) {
            addCriterion("sale_time between", value1, value2, "saleTime");
            return (Criteria) this;
        }

        public Criteria andSaleTimeNotBetween(Date value1, Date value2) {
            addCriterion("sale_time not between", value1, value2, "saleTime");
            return (Criteria) this;
        }

        public Criteria andSaleRejectRemarkIsNull() {
            addCriterion("sale_reject_remark is null");
            return (Criteria) this;
        }

        public Criteria andSaleRejectRemarkIsNotNull() {
            addCriterion("sale_reject_remark is not null");
            return (Criteria) this;
        }

        public Criteria andSaleRejectRemarkEqualTo(Integer value) {
            addCriterion("sale_reject_remark =", value, "saleRejectRemark");
            return (Criteria) this;
        }

        public Criteria andSaleRejectRemarkNotEqualTo(Integer value) {
            addCriterion("sale_reject_remark <>", value, "saleRejectRemark");
            return (Criteria) this;
        }

        public Criteria andSaleRejectRemarkGreaterThan(Integer value) {
            addCriterion("sale_reject_remark >", value, "saleRejectRemark");
            return (Criteria) this;
        }

        public Criteria andSaleRejectRemarkGreaterThanOrEqualTo(Integer value) {
            addCriterion("sale_reject_remark >=", value, "saleRejectRemark");
            return (Criteria) this;
        }

        public Criteria andSaleRejectRemarkLessThan(Integer value) {
            addCriterion("sale_reject_remark <", value, "saleRejectRemark");
            return (Criteria) this;
        }

        public Criteria andSaleRejectRemarkLessThanOrEqualTo(Integer value) {
            addCriterion("sale_reject_remark <=", value, "saleRejectRemark");
            return (Criteria) this;
        }

        public Criteria andSaleRejectRemarkIn(List<Integer> values) {
            addCriterion("sale_reject_remark in", values, "saleRejectRemark");
            return (Criteria) this;
        }

        public Criteria andSaleRejectRemarkNotIn(List<Integer> values) {
            addCriterion("sale_reject_remark not in", values, "saleRejectRemark");
            return (Criteria) this;
        }

        public Criteria andSaleRejectRemarkBetween(Integer value1, Integer value2) {
            addCriterion("sale_reject_remark between", value1, value2, "saleRejectRemark");
            return (Criteria) this;
        }

        public Criteria andSaleRejectRemarkNotBetween(Integer value1, Integer value2) {
            addCriterion("sale_reject_remark not between", value1, value2, "saleRejectRemark");
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

        public Criteria andSaleTotalAmountIsNull() {
            addCriterion("sale_total_amount is null");
            return (Criteria) this;
        }

        public Criteria andSaleTotalAmountIsNotNull() {
            addCriterion("sale_total_amount is not null");
            return (Criteria) this;
        }

        public Criteria andSaleTotalAmountEqualTo(BigDecimal value) {
            addCriterion("sale_total_amount =", value, "saleTotalAmount");
            return (Criteria) this;
        }

        public Criteria andSaleTotalAmountNotEqualTo(BigDecimal value) {
            addCriterion("sale_total_amount <>", value, "saleTotalAmount");
            return (Criteria) this;
        }

        public Criteria andSaleTotalAmountGreaterThan(BigDecimal value) {
            addCriterion("sale_total_amount >", value, "saleTotalAmount");
            return (Criteria) this;
        }

        public Criteria andSaleTotalAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("sale_total_amount >=", value, "saleTotalAmount");
            return (Criteria) this;
        }

        public Criteria andSaleTotalAmountLessThan(BigDecimal value) {
            addCriterion("sale_total_amount <", value, "saleTotalAmount");
            return (Criteria) this;
        }

        public Criteria andSaleTotalAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("sale_total_amount <=", value, "saleTotalAmount");
            return (Criteria) this;
        }

        public Criteria andSaleTotalAmountIn(List<BigDecimal> values) {
            addCriterion("sale_total_amount in", values, "saleTotalAmount");
            return (Criteria) this;
        }

        public Criteria andSaleTotalAmountNotIn(List<BigDecimal> values) {
            addCriterion("sale_total_amount not in", values, "saleTotalAmount");
            return (Criteria) this;
        }

        public Criteria andSaleTotalAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("sale_total_amount between", value1, value2, "saleTotalAmount");
            return (Criteria) this;
        }

        public Criteria andSaleTotalAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("sale_total_amount not between", value1, value2, "saleTotalAmount");
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