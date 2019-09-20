package local.skylerwebdev.sprintbookstore.models;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

@ApiModel(value = "Section", description = "Section Entity")
@Entity
@Table
public class Section
{
    @ApiModelProperty(name = "sectionid", value = "Primary Key for Section", required = true, example = "1")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long sectionid;

    @ApiModelProperty(name = "name", value = "Name of section", required = false, example = "Fiction")
    private String name;

    @OneToOne(mappedBy = "section")
    private Book book;
}
