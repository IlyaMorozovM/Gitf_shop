package com.epam.esm.dao.config;

import com.epam.esm.dao.GiftCertificateDAO;
import com.epam.esm.dao.TagDao;
import com.epam.esm.dao.extractor.GiftCertificateExtractor;
import com.epam.esm.dao.impl.GiftCertificateDaoImpl;
import com.epam.esm.dao.impl.TagDaoImpl;
import com.epam.esm.dao.mapper.GiftCertificateMapper;
import com.epam.esm.dao.mapper.TagRowMapper;
import com.epam.esm.model.GiftCertificate;
import com.epam.esm.model.Tag;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.List;

@Configuration
@PropertySource("classpath:db.properties")
@EnableTransactionManagement
public class DAOConfig {


        //TODO: перенести конфиг БД на уровень persistence
        @Value("${db.driver}")
        private String driver;

        @Value("${db.url}")
        private String url;

        @Value("${db.username}")
        private String username;

        @Value("${db.password}")
        private String password;

        @Value("${db.size}")
        private int maxPoolSize;

        @Bean
        public static PropertySourcesPlaceholderConfigurer placeHolderConfigurer() {
            return new PropertySourcesPlaceholderConfigurer();
        }

        @Bean
        public DataSource dataSource() {
            HikariConfig cfg = new HikariConfig();
            cfg.setDriverClassName(driver);
            cfg.setJdbcUrl(url);
            cfg.setUsername(username);
            cfg.setPassword(password);
            cfg.setMaximumPoolSize(maxPoolSize);
            return new HikariDataSource(cfg);
        }

        @Bean
        public JdbcTemplate jdbcTemplate(DataSource dataSource) {
            return new JdbcTemplate(dataSource);
        }

        @Bean
        public TagRowMapper tagRowMapper() {
            return new TagRowMapper();
        }

        @Bean
        public GiftCertificateExtractor giftCertificateExtractor() {
            return new GiftCertificateExtractor();
        }

        @Bean
        public TagDaoImpl tagDAO(JdbcTemplate jdbcTemplate, RowMapper<Tag> rowMapper) {
            return new TagDaoImpl(jdbcTemplate, rowMapper);
        }

        @Bean
        public RowMapper<GiftCertificate> giftCertificateMapper() {
            return new GiftCertificateMapper();
        }

        @Bean
        public GiftCertificateDaoImpl giftCertificateDao(
                JdbcTemplate jdbcTemplate, ResultSetExtractor<List<GiftCertificate>> giftCertificateExtractor,
                RowMapper<GiftCertificate> mapper) {
            return new GiftCertificateDaoImpl(jdbcTemplate, giftCertificateExtractor, mapper);
        }

        @Bean
        public PlatformTransactionManager transactionManager(DataSource dataSource) {
            return new DataSourceTransactionManager(dataSource);
    }


}
