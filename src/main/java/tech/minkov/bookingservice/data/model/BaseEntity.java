package tech.minkov.bookingservice.data.model;

import java.util.Date;
import java.util.UUID;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@MappedSuperclass
@Getter
@Setter
@ToString
public abstract class BaseEntity {

    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Id
    private UUID id;
    @CreatedDate
    @GeneratedValue
    private Date createdAt;
    @LastModifiedDate
    @GeneratedValue
    private Date modifiedAt;
    @Version
    @GeneratedValue
    private long version;
}
