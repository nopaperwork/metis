
    create table nopaperwork.roles (
       id uuid not null,
        created_by varchar(200) not null,
        created_date timestamp(6) with time zone not null,
        last_modified_by varchar(200),
        last_modified_date timestamp(6) with time zone,
        status varchar(50) not null,
        description varchar(200) not null,
        name varchar(50) not null,
        primary key (id)
    );

    create table nopaperwork.user_authorities (
       id uuid not null,
        created_by varchar(200) not null,
        created_date timestamp(6) with time zone not null,
        last_modified_by varchar(200),
        last_modified_date timestamp(6) with time zone,
        status varchar(50) not null,
        description varchar(200) not null,
        name varchar(50) not null,
        primary key (id)
    );

    create table nopaperwork.user_signin_log (
       id uuid not null,
        access_token varchar(512) not null,
        created_by varchar(200) not null,
        created_date timestamp(6) with time zone not null,
        device_code varchar(512) not null,
        email varchar(100) not null,
        header_value jsonb,
        identity varchar(100) not null,
        ip varchar(512) not null,
        mobile varchar(20) not null,
        role varchar(20) not null,
        status varchar(50) not null,
        time_zone varchar(512) not null,
        user_agent varchar(512) not null,
        user_id uuid,
        username varchar(50) not null,
        primary key (id)
    );

    create table nopaperwork.user_token (
       id uuid not null,
        created_by varchar(200) not null,
        created_date timestamp(6) with time zone not null,
        last_modified_by varchar(200),
        last_modified_date timestamp(6) with time zone,
        status varchar(50) not null,
        expired boolean not null,
        revoked boolean not null,
        token varchar(512) not null,
        role varchar(20) not null,
        user_id uuid,
        primary key (id)
    );

    create table nopaperwork.users (
       id uuid not null,
        created_by varchar(200) not null,
        created_date timestamp(6) with time zone not null,
        last_modified_by varchar(200),
        last_modified_date timestamp(6) with time zone,
        status varchar(50) not null,
        device_code varchar(512) not null,
        email varchar(100) not null,
        header_value jsonb,
        ip varchar(512) not null,
        mobile varchar(20) not null,
        password varchar(512) not null,
        role varchar(20) not null,
        time_zone varchar(512) not null,
        username varchar(50) not null,
        primary key (id)
    );

    alter table if exists nopaperwork.roles 
       add constraint UKofx66keruapi6vyqpv6f2or37 unique (name);

    alter table if exists nopaperwork.user_authorities 
       add constraint UKfxh32buxougyig294aw1n0he unique (name);

    alter table if exists nopaperwork.user_token 
       add constraint UKd7yi5lamexan0nwfelloh5yam unique (user_id, token);

    alter table if exists nopaperwork.user_token 
       add constraint UK_rif72qe73gbnjan23nhglof67 unique (token);

    alter table if exists nopaperwork.users 
       add constraint UKbeoq7xcqh1t8tuybblhx1e95d unique (email, status);

    alter table if exists nopaperwork.users 
       add constraint UK_6dotkott2kjsp8vw4d0m25fb7 unique (email);

    alter table if exists nopaperwork.users 
       add constraint UK_r43af9ap4edm43mmtq01oddj6 unique (username);

    create table nopaperwork.user_authority_map (
       user_id uuid not null,
        authority_id uuid not null,
        primary key (user_id, authority_id)
    );

    alter table if exists nopaperwork.user_token 
       add constraint FKfadr8tg4d19axmfe9fltvrmqt 
       foreign key (user_id) 
       references nopaperwork.users;

    alter table if exists nopaperwork.user_authority_map 
       add constraint FKgs4uqcwg4y2x75uht48f9203l 
       foreign key (authority_id) 
       references nopaperwork.user_authorities;

    alter table if exists nopaperwork.user_authority_map 
       add constraint FKra2f873l4auabpknk8fu39alu 
       foreign key (user_id) 
       references nopaperwork.users;

    create table nopaperwork.roles (
       id uuid not null,
        created_by varchar(200) not null,
        created_date timestamp(6) with time zone not null,
        last_modified_by varchar(200),
        last_modified_date timestamp(6) with time zone,
        status varchar(50) not null,
        description varchar(200) not null,
        name varchar(50) not null,
        primary key (id)
    );

    create table nopaperwork.user_authorities (
       id uuid not null,
        created_by varchar(200) not null,
        created_date timestamp(6) with time zone not null,
        last_modified_by varchar(200),
        last_modified_date timestamp(6) with time zone,
        status varchar(50) not null,
        description varchar(200) not null,
        name varchar(50) not null,
        primary key (id)
    );

    create table nopaperwork.user_signin_log (
       id uuid not null,
        access_token varchar(512) not null,
        created_by varchar(200) not null,
        created_date timestamp(6) with time zone not null,
        device_code varchar(512) not null,
        email varchar(100) not null,
        header_value jsonb,
        identity varchar(100) not null,
        ip varchar(512) not null,
        mobile varchar(20) not null,
        role varchar(20) not null,
        status varchar(50) not null,
        time_zone varchar(512) not null,
        user_agent varchar(512) not null,
        user_id uuid,
        username varchar(50) not null,
        primary key (id)
    );

    create table nopaperwork.user_token (
       id uuid not null,
        created_by varchar(200) not null,
        created_date timestamp(6) with time zone not null,
        last_modified_by varchar(200),
        last_modified_date timestamp(6) with time zone,
        status varchar(50) not null,
        expired boolean not null,
        revoked boolean not null,
        token varchar(512) not null,
        role varchar(20) not null,
        user_id uuid,
        primary key (id)
    );

    create table nopaperwork.users (
       id uuid not null,
        created_by varchar(200) not null,
        created_date timestamp(6) with time zone not null,
        last_modified_by varchar(200),
        last_modified_date timestamp(6) with time zone,
        status varchar(50) not null,
        device_code varchar(512) not null,
        email varchar(100) not null,
        header_value jsonb,
        ip varchar(512) not null,
        mobile varchar(20) not null,
        password varchar(512) not null,
        role varchar(20) not null,
        time_zone varchar(512) not null,
        username varchar(50) not null,
        primary key (id)
    );

    alter table if exists nopaperwork.roles 
       add constraint UKofx66keruapi6vyqpv6f2or37 unique (name);

    alter table if exists nopaperwork.user_authorities 
       add constraint UKfxh32buxougyig294aw1n0he unique (name);

    alter table if exists nopaperwork.user_token 
       add constraint UKd7yi5lamexan0nwfelloh5yam unique (user_id, token);

    alter table if exists nopaperwork.user_token 
       add constraint UK_rif72qe73gbnjan23nhglof67 unique (token);

    alter table if exists nopaperwork.users 
       add constraint UKbeoq7xcqh1t8tuybblhx1e95d unique (email, status);

    alter table if exists nopaperwork.users 
       add constraint UK_6dotkott2kjsp8vw4d0m25fb7 unique (email);

    alter table if exists nopaperwork.users 
       add constraint UK_r43af9ap4edm43mmtq01oddj6 unique (username);

    create table nopaperwork.user_authority_map (
       user_id uuid not null,
        authority_id uuid not null,
        primary key (user_id, authority_id)
    );

    alter table if exists nopaperwork.user_token 
       add constraint FKfadr8tg4d19axmfe9fltvrmqt 
       foreign key (user_id) 
       references nopaperwork.users;

    alter table if exists nopaperwork.user_authority_map 
       add constraint FKgs4uqcwg4y2x75uht48f9203l 
       foreign key (authority_id) 
       references nopaperwork.user_authorities;

    alter table if exists nopaperwork.user_authority_map 
       add constraint FKra2f873l4auabpknk8fu39alu 
       foreign key (user_id) 
       references nopaperwork.users;

    create table nopaperwork.roles (
       id uuid not null,
        created_by varchar(200) not null,
        created_date timestamp(6) with time zone not null,
        last_modified_by varchar(200),
        last_modified_date timestamp(6) with time zone,
        status varchar(50) not null,
        description varchar(200) not null,
        name varchar(50) not null,
        primary key (id)
    );

    create table nopaperwork.user_authorities (
       id uuid not null,
        created_by varchar(200) not null,
        created_date timestamp(6) with time zone not null,
        last_modified_by varchar(200),
        last_modified_date timestamp(6) with time zone,
        status varchar(50) not null,
        description varchar(200) not null,
        name varchar(50) not null,
        primary key (id)
    );

    create table nopaperwork.user_signin_log (
       id uuid not null,
        access_token varchar(512) not null,
        created_by varchar(200) not null,
        created_date timestamp(6) with time zone not null,
        device_code varchar(512) not null,
        email varchar(100) not null,
        header_value jsonb,
        identity varchar(100) not null,
        ip varchar(512) not null,
        mobile varchar(20) not null,
        role varchar(20) not null,
        status varchar(50) not null,
        time_zone varchar(512) not null,
        user_agent varchar(512) not null,
        user_id uuid,
        username varchar(50) not null,
        primary key (id)
    );

    create table nopaperwork.user_token (
       id uuid not null,
        created_by varchar(200) not null,
        created_date timestamp(6) with time zone not null,
        last_modified_by varchar(200),
        last_modified_date timestamp(6) with time zone,
        status varchar(50) not null,
        expired boolean not null,
        revoked boolean not null,
        token varchar(512) not null,
        role varchar(20) not null,
        user_id uuid,
        primary key (id)
    );

    create table nopaperwork.users (
       id uuid not null,
        created_by varchar(200) not null,
        created_date timestamp(6) with time zone not null,
        last_modified_by varchar(200),
        last_modified_date timestamp(6) with time zone,
        status varchar(50) not null,
        device_code varchar(512) not null,
        email varchar(100) not null,
        header_value jsonb,
        ip varchar(512) not null,
        mobile varchar(20) not null,
        password varchar(512) not null,
        role varchar(20) not null,
        time_zone varchar(512) not null,
        username varchar(50) not null,
        primary key (id)
    );

    alter table if exists nopaperwork.roles 
       add constraint UKofx66keruapi6vyqpv6f2or37 unique (name);

    alter table if exists nopaperwork.user_authorities 
       add constraint UKfxh32buxougyig294aw1n0he unique (name);

    alter table if exists nopaperwork.user_token 
       add constraint UKd7yi5lamexan0nwfelloh5yam unique (user_id, token);

    alter table if exists nopaperwork.user_token 
       add constraint UK_rif72qe73gbnjan23nhglof67 unique (token);

    alter table if exists nopaperwork.users 
       add constraint UKbeoq7xcqh1t8tuybblhx1e95d unique (email, status);

    alter table if exists nopaperwork.users 
       add constraint UK_6dotkott2kjsp8vw4d0m25fb7 unique (email);

    alter table if exists nopaperwork.users 
       add constraint UK_r43af9ap4edm43mmtq01oddj6 unique (username);

    create table nopaperwork.user_authority_map (
       user_id uuid not null,
        authority_id uuid not null,
        primary key (user_id, authority_id)
    );

    alter table if exists nopaperwork.user_token 
       add constraint FKfadr8tg4d19axmfe9fltvrmqt 
       foreign key (user_id) 
       references nopaperwork.users;

    alter table if exists nopaperwork.user_authority_map 
       add constraint FKgs4uqcwg4y2x75uht48f9203l 
       foreign key (authority_id) 
       references nopaperwork.user_authorities;

    alter table if exists nopaperwork.user_authority_map 
       add constraint FKra2f873l4auabpknk8fu39alu 
       foreign key (user_id) 
       references nopaperwork.users;

    create table nopaperwork.roles (
       id uuid not null,
        created_by varchar(200) not null,
        created_date timestamp(6) with time zone not null,
        last_modified_by varchar(200),
        last_modified_date timestamp(6) with time zone,
        status varchar(50) not null,
        description varchar(200) not null,
        name varchar(50) not null,
        primary key (id)
    );

    create table nopaperwork.user_authorities (
       id uuid not null,
        created_by varchar(200) not null,
        created_date timestamp(6) with time zone not null,
        last_modified_by varchar(200),
        last_modified_date timestamp(6) with time zone,
        status varchar(50) not null,
        description varchar(200) not null,
        name varchar(50) not null,
        primary key (id)
    );

    create table nopaperwork.user_signin_log (
       id uuid not null,
        access_token varchar(512) not null,
        created_by varchar(200) not null,
        created_date timestamp(6) with time zone not null,
        device_code varchar(512) not null,
        email varchar(100) not null,
        header_value jsonb,
        identity varchar(100) not null,
        ip varchar(512) not null,
        mobile varchar(20) not null,
        role varchar(20) not null,
        status varchar(50) not null,
        time_zone varchar(512) not null,
        user_agent varchar(512) not null,
        user_id uuid,
        username varchar(50) not null,
        primary key (id)
    );

    create table nopaperwork.user_token (
       id uuid not null,
        created_by varchar(200) not null,
        created_date timestamp(6) with time zone not null,
        last_modified_by varchar(200),
        last_modified_date timestamp(6) with time zone,
        status varchar(50) not null,
        expired boolean not null,
        revoked boolean not null,
        token varchar(512) not null,
        role varchar(20) not null,
        user_id uuid,
        primary key (id)
    );

    create table nopaperwork.users (
       id uuid not null,
        created_by varchar(200) not null,
        created_date timestamp(6) with time zone not null,
        last_modified_by varchar(200),
        last_modified_date timestamp(6) with time zone,
        status varchar(50) not null,
        device_code varchar(512) not null,
        email varchar(100) not null,
        header_value jsonb,
        ip varchar(512) not null,
        mobile varchar(20) not null,
        password varchar(512) not null,
        role varchar(20) not null,
        time_zone varchar(512) not null,
        username varchar(50) not null,
        primary key (id)
    );

    alter table if exists nopaperwork.roles 
       add constraint UKofx66keruapi6vyqpv6f2or37 unique (name);

    alter table if exists nopaperwork.user_authorities 
       add constraint UKfxh32buxougyig294aw1n0he unique (name);

    alter table if exists nopaperwork.user_token 
       add constraint UKd7yi5lamexan0nwfelloh5yam unique (user_id, token);

    alter table if exists nopaperwork.user_token 
       add constraint UK_rif72qe73gbnjan23nhglof67 unique (token);

    alter table if exists nopaperwork.users 
       add constraint UKbeoq7xcqh1t8tuybblhx1e95d unique (email, status);

    alter table if exists nopaperwork.users 
       add constraint UK_6dotkott2kjsp8vw4d0m25fb7 unique (email);

    alter table if exists nopaperwork.users 
       add constraint UK_r43af9ap4edm43mmtq01oddj6 unique (username);

    create table nopaperwork.user_authority_map (
       user_id uuid not null,
        authority_id uuid not null,
        primary key (user_id, authority_id)
    );

    alter table if exists nopaperwork.user_token 
       add constraint FKfadr8tg4d19axmfe9fltvrmqt 
       foreign key (user_id) 
       references nopaperwork.users;

    alter table if exists nopaperwork.user_authority_map 
       add constraint FKgs4uqcwg4y2x75uht48f9203l 
       foreign key (authority_id) 
       references nopaperwork.user_authorities;

    alter table if exists nopaperwork.user_authority_map 
       add constraint FKra2f873l4auabpknk8fu39alu 
       foreign key (user_id) 
       references nopaperwork.users;

    create table nopaperwork.roles (
       id uuid not null,
        created_by varchar(200) not null,
        created_date timestamp(6) with time zone not null,
        last_modified_by varchar(200),
        last_modified_date timestamp(6) with time zone,
        status varchar(50) not null,
        description varchar(200) not null,
        name varchar(50) not null,
        primary key (id)
    );

    create table nopaperwork.user_authorities (
       id uuid not null,
        created_by varchar(200) not null,
        created_date timestamp(6) with time zone not null,
        last_modified_by varchar(200),
        last_modified_date timestamp(6) with time zone,
        status varchar(50) not null,
        description varchar(200) not null,
        name varchar(50) not null,
        primary key (id)
    );

    create table nopaperwork.user_signin_log (
       id uuid not null,
        access_token varchar(512) not null,
        created_by varchar(200) not null,
        created_date timestamp(6) with time zone not null,
        device_code varchar(512) not null,
        email varchar(100) not null,
        header_value jsonb,
        identity varchar(100) not null,
        ip varchar(512) not null,
        mobile varchar(20) not null,
        role varchar(20) not null,
        status varchar(50) not null,
        time_zone varchar(512) not null,
        user_agent varchar(512) not null,
        user_id uuid,
        username varchar(50) not null,
        primary key (id)
    );

    create table nopaperwork.user_token (
       id uuid not null,
        created_by varchar(200) not null,
        created_date timestamp(6) with time zone not null,
        last_modified_by varchar(200),
        last_modified_date timestamp(6) with time zone,
        status varchar(50) not null,
        expired boolean not null,
        revoked boolean not null,
        token varchar(512) not null,
        role varchar(20) not null,
        user_id uuid,
        primary key (id)
    );

    create table nopaperwork.users (
       id uuid not null,
        created_by varchar(200) not null,
        created_date timestamp(6) with time zone not null,
        last_modified_by varchar(200),
        last_modified_date timestamp(6) with time zone,
        status varchar(50) not null,
        device_code varchar(512) not null,
        email varchar(100) not null,
        header_value jsonb,
        ip varchar(512) not null,
        mobile varchar(20) not null,
        password varchar(512) not null,
        role varchar(20) not null,
        time_zone varchar(512) not null,
        username varchar(50) not null,
        primary key (id)
    );

    alter table if exists nopaperwork.roles 
       add constraint UKofx66keruapi6vyqpv6f2or37 unique (name);

    alter table if exists nopaperwork.user_authorities 
       add constraint UKfxh32buxougyig294aw1n0he unique (name);

    alter table if exists nopaperwork.user_token 
       add constraint UKd7yi5lamexan0nwfelloh5yam unique (user_id, token);

    alter table if exists nopaperwork.user_token 
       add constraint UK_rif72qe73gbnjan23nhglof67 unique (token);

    alter table if exists nopaperwork.users 
       add constraint UKbeoq7xcqh1t8tuybblhx1e95d unique (email, status);

    alter table if exists nopaperwork.users 
       add constraint UK_6dotkott2kjsp8vw4d0m25fb7 unique (email);

    alter table if exists nopaperwork.users 
       add constraint UK_r43af9ap4edm43mmtq01oddj6 unique (username);

    create table nopaperwork.user_authority_map (
       user_id uuid not null,
        authority_id uuid not null,
        primary key (user_id, authority_id)
    );

    alter table if exists nopaperwork.user_token 
       add constraint FKfadr8tg4d19axmfe9fltvrmqt 
       foreign key (user_id) 
       references nopaperwork.users;

    alter table if exists nopaperwork.user_authority_map 
       add constraint FKgs4uqcwg4y2x75uht48f9203l 
       foreign key (authority_id) 
       references nopaperwork.user_authorities;

    alter table if exists nopaperwork.user_authority_map 
       add constraint FKra2f873l4auabpknk8fu39alu 
       foreign key (user_id) 
       references nopaperwork.users;

    create table nopaperwork.roles (
       id uuid not null,
        created_by varchar(200) not null,
        created_date timestamp(6) with time zone not null,
        last_modified_by varchar(200),
        last_modified_date timestamp(6) with time zone,
        status varchar(50) not null,
        description varchar(200) not null,
        name varchar(50) not null,
        primary key (id)
    );

    create table nopaperwork.user_authorities (
       id uuid not null,
        created_by varchar(200) not null,
        created_date timestamp(6) with time zone not null,
        last_modified_by varchar(200),
        last_modified_date timestamp(6) with time zone,
        status varchar(50) not null,
        description varchar(200) not null,
        name varchar(50) not null,
        primary key (id)
    );

    create table nopaperwork.user_signin_log (
       id uuid not null,
        access_token varchar(512) not null,
        created_by varchar(200) not null,
        created_date timestamp(6) with time zone not null,
        device_code varchar(512) not null,
        email varchar(100) not null,
        header_value jsonb,
        identity varchar(100) not null,
        ip varchar(512) not null,
        mobile varchar(20) not null,
        role varchar(20) not null,
        status varchar(50) not null,
        time_zone varchar(512) not null,
        user_agent varchar(512) not null,
        user_id uuid,
        username varchar(50) not null,
        primary key (id)
    );

    create table nopaperwork.user_token (
       id uuid not null,
        created_by varchar(200) not null,
        created_date timestamp(6) with time zone not null,
        last_modified_by varchar(200),
        last_modified_date timestamp(6) with time zone,
        status varchar(50) not null,
        expired boolean not null,
        revoked boolean not null,
        token varchar(512) not null,
        role varchar(20) not null,
        user_id uuid,
        primary key (id)
    );

    create table nopaperwork.users (
       id uuid not null,
        created_by varchar(200) not null,
        created_date timestamp(6) with time zone not null,
        last_modified_by varchar(200),
        last_modified_date timestamp(6) with time zone,
        status varchar(50) not null,
        device_code varchar(512) not null,
        email varchar(100) not null,
        header_value jsonb,
        ip varchar(512) not null,
        mobile varchar(20) not null,
        password varchar(512) not null,
        role varchar(20) not null,
        time_zone varchar(512) not null,
        username varchar(50) not null,
        primary key (id)
    );

    alter table if exists nopaperwork.roles 
       add constraint UKofx66keruapi6vyqpv6f2or37 unique (name);

    alter table if exists nopaperwork.user_authorities 
       add constraint UKfxh32buxougyig294aw1n0he unique (name);

    alter table if exists nopaperwork.user_token 
       add constraint UKd7yi5lamexan0nwfelloh5yam unique (user_id, token);

    alter table if exists nopaperwork.user_token 
       add constraint UK_rif72qe73gbnjan23nhglof67 unique (token);

    alter table if exists nopaperwork.users 
       add constraint UKbeoq7xcqh1t8tuybblhx1e95d unique (email, status);

    alter table if exists nopaperwork.users 
       add constraint UK_6dotkott2kjsp8vw4d0m25fb7 unique (email);

    alter table if exists nopaperwork.users 
       add constraint UK_r43af9ap4edm43mmtq01oddj6 unique (username);

    create table nopaperwork.user_authority_map (
       user_id uuid not null,
        authority_id uuid not null,
        primary key (user_id, authority_id)
    );

    alter table if exists nopaperwork.user_token 
       add constraint FKfadr8tg4d19axmfe9fltvrmqt 
       foreign key (user_id) 
       references nopaperwork.users;

    alter table if exists nopaperwork.user_authority_map 
       add constraint FKgs4uqcwg4y2x75uht48f9203l 
       foreign key (authority_id) 
       references nopaperwork.user_authorities;

    alter table if exists nopaperwork.user_authority_map 
       add constraint FKra2f873l4auabpknk8fu39alu 
       foreign key (user_id) 
       references nopaperwork.users;

    create table nopaperwork.roles (
       id uuid not null,
        created_by varchar(200) not null,
        created_date timestamp(6) with time zone not null,
        last_modified_by varchar(200),
        last_modified_date timestamp(6) with time zone,
        status varchar(50) not null,
        description varchar(200) not null,
        name varchar(50) not null,
        primary key (id)
    );

    create table nopaperwork.user_authorities (
       id uuid not null,
        created_by varchar(200) not null,
        created_date timestamp(6) with time zone not null,
        last_modified_by varchar(200),
        last_modified_date timestamp(6) with time zone,
        status varchar(50) not null,
        description varchar(200) not null,
        name varchar(50) not null,
        primary key (id)
    );

    create table nopaperwork.user_signin_log (
       id uuid not null,
        access_token varchar(512) not null,
        created_by varchar(200) not null,
        created_date timestamp(6) with time zone not null,
        device_code varchar(512) not null,
        email varchar(100) not null,
        header_value jsonb,
        identity varchar(100) not null,
        ip varchar(512) not null,
        mobile varchar(20) not null,
        role varchar(20) not null,
        status varchar(50) not null,
        time_zone varchar(512) not null,
        user_agent varchar(512) not null,
        user_id uuid,
        username varchar(50) not null,
        primary key (id)
    );

    create table nopaperwork.user_token (
       id uuid not null,
        created_by varchar(200) not null,
        created_date timestamp(6) with time zone not null,
        last_modified_by varchar(200),
        last_modified_date timestamp(6) with time zone,
        status varchar(50) not null,
        expired boolean not null,
        revoked boolean not null,
        token varchar(512) not null,
        role varchar(20) not null,
        user_id uuid,
        primary key (id)
    );

    create table nopaperwork.users (
       id uuid not null,
        created_by varchar(200) not null,
        created_date timestamp(6) with time zone not null,
        last_modified_by varchar(200),
        last_modified_date timestamp(6) with time zone,
        status varchar(50) not null,
        device_code varchar(512) not null,
        email varchar(100) not null,
        header_value jsonb,
        ip varchar(512) not null,
        mobile varchar(20) not null,
        password varchar(512) not null,
        role varchar(20) not null,
        time_zone varchar(512) not null,
        username varchar(50) not null,
        primary key (id)
    );

    alter table if exists nopaperwork.roles 
       add constraint UKofx66keruapi6vyqpv6f2or37 unique (name);

    alter table if exists nopaperwork.user_authorities 
       add constraint UKfxh32buxougyig294aw1n0he unique (name);

    alter table if exists nopaperwork.user_token 
       add constraint UKd7yi5lamexan0nwfelloh5yam unique (user_id, token);

    alter table if exists nopaperwork.user_token 
       add constraint UK_rif72qe73gbnjan23nhglof67 unique (token);

    alter table if exists nopaperwork.users 
       add constraint UKbeoq7xcqh1t8tuybblhx1e95d unique (email, status);

    alter table if exists nopaperwork.users 
       add constraint UK_6dotkott2kjsp8vw4d0m25fb7 unique (email);

    alter table if exists nopaperwork.users 
       add constraint UK_r43af9ap4edm43mmtq01oddj6 unique (username);

    create table nopaperwork.user_authority_map (
       user_id uuid not null,
        authority_id uuid not null,
        primary key (user_id, authority_id)
    );

    alter table if exists nopaperwork.user_token 
       add constraint FKfadr8tg4d19axmfe9fltvrmqt 
       foreign key (user_id) 
       references nopaperwork.users;

    alter table if exists nopaperwork.user_authority_map 
       add constraint FKgs4uqcwg4y2x75uht48f9203l 
       foreign key (authority_id) 
       references nopaperwork.user_authorities;

    alter table if exists nopaperwork.user_authority_map 
       add constraint FKra2f873l4auabpknk8fu39alu 
       foreign key (user_id) 
       references nopaperwork.users;
