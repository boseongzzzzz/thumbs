package com.boram.life.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter @Setter
public class Documents {

    // 문서 번호 (SEQ), '기안(draft)'과 완성된 '문서(document)'를 따로 나누지 않고 하나의 entity로 관리함.
    @Id @GeneratedValue
    @Column(name = "document_no")
    private Long documentNo;

    // 문서 형식
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "form_no")
    private Form form;

    // 문서 1결재자 (=기안자)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member ApprovalMember1;

    // 문서 2결재자 (=중간결재자)
    @Column(name = "document_Member2")
    private String ApprovalMember2;

    // 문서 3결재자 (=최종결재자)
    @Column(name = "document_member3")
    private String ApprovalMember3;

    // 문서 제목
    @Column(name = "document_title")
    private String documentTitle;

    // 문서 내용
    @Column(name = "document_details")
    private String documentDetails;

    // 문서 상태
    @Column(name = "document_status")
    private String documentStatus;

    // 문서 기안 일자
    @Column(name = "document_draft_date")
    private Date documentDraftDate;

    // 문서 (최종)결재 일자
    @Column(name = "document_approval_date")
    private Date documentApprovalDate;

    // 문서 반려 사항
    @OneToOne(mappedBy = "rejectNo")
    private Reject documentReject;

    // 문서 첨부파일
    @OneToMany(mappedBy = "attachmentNo")
    private List<Attachments> documentAttachments;

}
