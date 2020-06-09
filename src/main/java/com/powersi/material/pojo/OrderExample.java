package com.powersi.material.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrderExample() {
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

        public Criteria andOrderOperDateIsNull() {
            addCriterion("order_oper_date is null");
            return (Criteria) this;
        }

        public Criteria andOrderOperDateIsNotNull() {
            addCriterion("order_oper_date is not null");
            return (Criteria) this;
        }

        public Criteria andOrderOperDateEqualTo(Date value) {
            addCriterion("order_oper_date =", value, "orderOperDate");
            return (Criteria) this;
        }

        public Criteria andOrderOperDateNotEqualTo(Date value) {
            addCriterion("order_oper_date <>", value, "orderOperDate");
            return (Criteria) this;
        }

        public Criteria andOrderOperDateGreaterThan(Date value) {
            addCriterion("order_oper_date >", value, "orderOperDate");
            return (Criteria) this;
        }

        public Criteria andOrderOperDateGreaterThanOrEqualTo(Date value) {
            addCriterion("order_oper_date >=", value, "orderOperDate");
            return (Criteria) this;
        }

        public Criteria andOrderOperDateLessThan(Date value) {
            addCriterion("order_oper_date <", value, "orderOperDate");
            return (Criteria) this;
        }

        public Criteria andOrderOperDateLessThanOrEqualTo(Date value) {
            addCriterion("order_oper_date <=", value, "orderOperDate");
            return (Criteria) this;
        }

        public Criteria andOrderOperDateIn(List<Date> values) {
            addCriterion("order_oper_date in", values, "orderOperDate");
            return (Criteria) this;
        }

        public Criteria andOrderOperDateNotIn(List<Date> values) {
            addCriterion("order_oper_date not in", values, "orderOperDate");
            return (Criteria) this;
        }

        public Criteria andOrderOperDateBetween(Date value1, Date value2) {
            addCriterion("order_oper_date between", value1, value2, "orderOperDate");
            return (Criteria) this;
        }

        public Criteria andOrderOperDateNotBetween(Date value1, Date value2) {
            addCriterion("order_oper_date not between", value1, value2, "orderOperDate");
            return (Criteria) this;
        }

        public Criteria andOrderIsArriveIsNull() {
            addCriterion("order_is_arrive is null");
            return (Criteria) this;
        }

        public Criteria andOrderIsArriveIsNotNull() {
            addCriterion("order_is_arrive is not null");
            return (Criteria) this;
        }

        public Criteria andOrderIsArriveEqualTo(String value) {
            addCriterion("order_is_arrive =", value, "orderIsArrive");
            return (Criteria) this;
        }

        public Criteria andOrderIsArriveNotEqualTo(String value) {
            addCriterion("order_is_arrive <>", value, "orderIsArrive");
            return (Criteria) this;
        }

        public Criteria andOrderIsArriveGreaterThan(String value) {
            addCriterion("order_is_arrive >", value, "orderIsArrive");
            return (Criteria) this;
        }

        public Criteria andOrderIsArriveGreaterThanOrEqualTo(String value) {
            addCriterion("order_is_arrive >=", value, "orderIsArrive");
            return (Criteria) this;
        }

        public Criteria andOrderIsArriveLessThan(String value) {
            addCriterion("order_is_arrive <", value, "orderIsArrive");
            return (Criteria) this;
        }

        public Criteria andOrderIsArriveLessThanOrEqualTo(String value) {
            addCriterion("order_is_arrive <=", value, "orderIsArrive");
            return (Criteria) this;
        }

        public Criteria andOrderIsArriveLike(String value) {
            addCriterion("order_is_arrive like", value, "orderIsArrive");
            return (Criteria) this;
        }

        public Criteria andOrderIsArriveNotLike(String value) {
            addCriterion("order_is_arrive not like", value, "orderIsArrive");
            return (Criteria) this;
        }

        public Criteria andOrderIsArriveIn(List<String> values) {
            addCriterion("order_is_arrive in", values, "orderIsArrive");
            return (Criteria) this;
        }

        public Criteria andOrderIsArriveNotIn(List<String> values) {
            addCriterion("order_is_arrive not in", values, "orderIsArrive");
            return (Criteria) this;
        }

        public Criteria andOrderIsArriveBetween(String value1, String value2) {
            addCriterion("order_is_arrive between", value1, value2, "orderIsArrive");
            return (Criteria) this;
        }

        public Criteria andOrderIsArriveNotBetween(String value1, String value2) {
            addCriterion("order_is_arrive not between", value1, value2, "orderIsArrive");
            return (Criteria) this;
        }

        public Criteria andOrdeStatusIsNull() {
            addCriterion("orde_status is null");
            return (Criteria) this;
        }

        public Criteria andOrdeStatusIsNotNull() {
            addCriterion("orde_status is not null");
            return (Criteria) this;
        }

        public Criteria andOrdeStatusEqualTo(String value) {
            addCriterion("orde_status =", value, "ordeStatus");
            return (Criteria) this;
        }

        public Criteria andOrdeStatusNotEqualTo(String value) {
            addCriterion("orde_status <>", value, "ordeStatus");
            return (Criteria) this;
        }

        public Criteria andOrdeStatusGreaterThan(String value) {
            addCriterion("orde_status >", value, "ordeStatus");
            return (Criteria) this;
        }

        public Criteria andOrdeStatusGreaterThanOrEqualTo(String value) {
            addCriterion("orde_status >=", value, "ordeStatus");
            return (Criteria) this;
        }

        public Criteria andOrdeStatusLessThan(String value) {
            addCriterion("orde_status <", value, "ordeStatus");
            return (Criteria) this;
        }

        public Criteria andOrdeStatusLessThanOrEqualTo(String value) {
            addCriterion("orde_status <=", value, "ordeStatus");
            return (Criteria) this;
        }

        public Criteria andOrdeStatusLike(String value) {
            addCriterion("orde_status like", value, "ordeStatus");
            return (Criteria) this;
        }

        public Criteria andOrdeStatusNotLike(String value) {
            addCriterion("orde_status not like", value, "ordeStatus");
            return (Criteria) this;
        }

        public Criteria andOrdeStatusIn(List<String> values) {
            addCriterion("orde_status in", values, "ordeStatus");
            return (Criteria) this;
        }

        public Criteria andOrdeStatusNotIn(List<String> values) {
            addCriterion("orde_status not in", values, "ordeStatus");
            return (Criteria) this;
        }

        public Criteria andOrdeStatusBetween(String value1, String value2) {
            addCriterion("orde_status between", value1, value2, "ordeStatus");
            return (Criteria) this;
        }

        public Criteria andOrdeStatusNotBetween(String value1, String value2) {
            addCriterion("orde_status not between", value1, value2, "ordeStatus");
            return (Criteria) this;
        }

        public Criteria andOrderAmountMoneyIsNull() {
            addCriterion("order_amount_money is null");
            return (Criteria) this;
        }

        public Criteria andOrderAmountMoneyIsNotNull() {
            addCriterion("order_amount_money is not null");
            return (Criteria) this;
        }

        public Criteria andOrderAmountMoneyEqualTo(BigDecimal value) {
            addCriterion("order_amount_money =", value, "orderAmountMoney");
            return (Criteria) this;
        }

        public Criteria andOrderAmountMoneyNotEqualTo(BigDecimal value) {
            addCriterion("order_amount_money <>", value, "orderAmountMoney");
            return (Criteria) this;
        }

        public Criteria andOrderAmountMoneyGreaterThan(BigDecimal value) {
            addCriterion("order_amount_money >", value, "orderAmountMoney");
            return (Criteria) this;
        }

        public Criteria andOrderAmountMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("order_amount_money >=", value, "orderAmountMoney");
            return (Criteria) this;
        }

        public Criteria andOrderAmountMoneyLessThan(BigDecimal value) {
            addCriterion("order_amount_money <", value, "orderAmountMoney");
            return (Criteria) this;
        }

        public Criteria andOrderAmountMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("order_amount_money <=", value, "orderAmountMoney");
            return (Criteria) this;
        }

        public Criteria andOrderAmountMoneyIn(List<BigDecimal> values) {
            addCriterion("order_amount_money in", values, "orderAmountMoney");
            return (Criteria) this;
        }

        public Criteria andOrderAmountMoneyNotIn(List<BigDecimal> values) {
            addCriterion("order_amount_money not in", values, "orderAmountMoney");
            return (Criteria) this;
        }

        public Criteria andOrderAmountMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("order_amount_money between", value1, value2, "orderAmountMoney");
            return (Criteria) this;
        }

        public Criteria andOrderAmountMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("order_amount_money not between", value1, value2, "orderAmountMoney");
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