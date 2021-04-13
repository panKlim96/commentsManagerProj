insert into usr (id, name, surname, passport_data, username, password, active)
    values(1, 'Klim', 'Pantelei', '7517154234','kliman','123', true);

insert into user_role (user_id, roles)
    values(1, 'USER'), (1, 'ADMIN');