-- 코드를 작성해주세요
select i.ID, i.EMAIL, i.FIRST_NAME, i.LAST_NAME from DEVELOPER_INFOS as i where i.SKILL_1 = 'Python' or i.SKILL_2 = 'Python' or i.SKILL_3 = 'Python' order by i.ID;