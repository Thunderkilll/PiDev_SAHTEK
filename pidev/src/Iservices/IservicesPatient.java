/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Iservices;

import Entite.Patient;
import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author khaled22
 */
public interface IservicesPatient {
    
     public void ajouter_Patient (Patient p);
      public void ajouter_Patient_Elts (String nom, String prenom, Date date_naissance, String password, String image);
    public void supprimer_Patient_Class(Patient p);
    public void supprimer_Patient_cin(int c);
    public void update_Info1 (Patient p ,String nom, String prenom, Date date_naissance);
    public void Update_Name_Patient (Patient p , String nom);
    public void Update_Pwd_Patient (Patient p , String password);
    public void Update_PatientComplete(Patient p ,String nom, String prenom, Date date_naissance, String password, String image);
    public void Afficher_Patients();
    public ArrayList<Patient> AfficherPatient();
    public void Afficher_Patient(Patient p);
    public Patient recherche_Patient(int id);
}
