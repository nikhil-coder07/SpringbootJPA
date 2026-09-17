package com.example.springjpa.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Food
{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;
  String foodName;
  double price;
  boolean isAvailable;


}
