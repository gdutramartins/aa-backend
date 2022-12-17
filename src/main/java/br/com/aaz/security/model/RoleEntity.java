package br.com.aaz.security.model;

import jakarta.persistence.*;


@Entity
@Table(name = "cad_role")
public class RoleEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Enumerated(EnumType.STRING)
  @Column(length = 20)
  private RoleNameEnum name;

  public RoleEntity() {

  }

  public RoleEntity(RoleNameEnum name) {
    this.name = name;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public RoleNameEnum getName() {
    return name;
  }

  public void setName(RoleNameEnum name) {
    this.name = name;
  }
}
