-- ȸ�� : ���̵�, ��й�ȣ, �̸�, ������ ����, ��������
create table tb_member (
    id varchar2(50) not null,
    pass varchar2(50) not null,
    name varchar2(50) not null,
    admin varchar2(50),
    reg_date date default sysdate
);

-- ��� : ��Ϲ�ȣ, ���̵�, �����ڵ�, ����, �������
create table tb_record (
    record_no number primary key,
    id varchar2(50) not null,
    test_code number not null,
    score number not null,
    record_date date default sysdate
);

-- ��ϻ� : ��Ϲ�ȣ, ������ȣ, ���俩��, ����, ����
create table tb_record_details (
    record_no number not null,
    quiz_no number not null,
    record_result varchar2(50) not null,
    record_answer number not null,
    quiz_answer number not null
);

-- ���� : �����ڵ�, �����̸�, �׷��ڵ�, ��������
create table tb_test (
    test_code number primary key,
    test_name varchar2(100) not null,
    group_code number,
    test_date date
);

-- ���� : �����ڵ�, ����, ������ȣ, ����, ����1~5, ����, ����
create table tb_test_quiz (
    test_code number not null,
    quiz_sub varchar2(50) not null,
    quiz_no number not null,
    quiz_question varchar2(300) not null,
    example_1 varchar2(100),
    example_2 varchar2(100),
    example_3 varchar2(100),
    example_4 varchar2(100),
    example_5 varchar2(100),
    quiz_answer number not null,
    quiz_score number not null,
    last_no varchar2(50),
    quiz_code number not null,
    primary key(test_code, quiz_code)
);


create sequence seq_record_no;
create sequence seq_test_code;
