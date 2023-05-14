use project_maneger_schema;
select  id, title, descreption , due_date, first_name, last_name from projects
inner join users on users.id = joinee_id
where joinee_id = 2 ;


SELECT
  projects.id,
  projects.title,
  projects.due_date,
  projects.leader_id,
  projects.joinee_id
FROM projects 
WHERE projects.id NOT IN (
  SELECT projects.id
  FROM projects
  WHERE joinee_id = 2
);





