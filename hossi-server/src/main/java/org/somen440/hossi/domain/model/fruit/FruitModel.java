package org.somen440.hossi.domain.model.fruit;

/**
 * フルーツのドメインモデル
 */
public class FruitModel {

  public int id;
  public String name;
  public String description;

  public FruitModel() {}

  /**
   * @param id フルーツID
   * @param name 名前
   * @param description 詳細
   */
  public FruitModel(int id, String name, String description) {
    this.id = id;
    this.name = name;
    this.description = description;
  }
}
