package com.powersi.material.controller;

import com.powersi.material.pojo.Member;
import com.powersi.material.pojo.MemberClass;
import com.powersi.material.pojo.responseBody.MemberRes;
import com.powersi.material.service.IMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @description: 会员管理
 * @author: Duan xiaoping
 * @mailbox: xiaoping.duan@powersi.com.cn
 * @create: 2020-06-10 11:34
 */
@RestController
@RequestMapping("member")
public class MemberController {

    @Autowired
    IMemberService memberService;

    @PostMapping("register")
    public ResponseEntity<Integer> register(@RequestBody Member member){
        int count = memberService.save(member);
        return ResponseEntity.ok(count);
    }

    @PostMapping("create_rule")
    public ResponseEntity<Integer> createRule(@RequestBody MemberClass memberClass){
        int count = memberService.createRule(memberClass);

        return ResponseEntity.ok(count);
    }

    @GetMapping("query_rule")
    public ResponseEntity<List> queryList(){
        List<MemberClass> memberClassList = memberService.getRuleList();
        return (ResponseEntity) ResponseEntity.ok(memberClassList);
    }

    @PostMapping("saveModify")
    public ResponseEntity<Integer> saveModify(@RequestBody List<MemberClass> list){

        int flag = memberService.updateMemberClass(list);
        return ResponseEntity.ok(flag);
    }

    @PostMapping("del_rule")
    public ResponseEntity<Integer> delRule(Integer ruleId){

        int flag = memberService.deleteMemberClass(ruleId);
        return (ResponseEntity) ResponseEntity.ok(flag);
    }
    @PostMapping("del_member")
    public ResponseEntity<Integer> delMember(String memberTelp){

        int flag = memberService.deleteMember(memberTelp);
        return ResponseEntity.ok(flag);
    }
    @GetMapping("query_member")
    public ResponseEntity<List> queryMember(){

        List memberList = memberService.getMemberList();
        return (ResponseEntity) ResponseEntity.ok(memberList);
    }
    @GetMapping("query_one")
    public ResponseEntity<MemberRes> queryMember(String memberTelp){

        MemberRes memberRes = memberService.getMemberInfo(memberTelp);
        return ResponseEntity.ok(memberRes);
    }

}
