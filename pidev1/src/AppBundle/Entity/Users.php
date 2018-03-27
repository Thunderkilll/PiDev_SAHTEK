<?php

namespace AppBundle\Entity;

/**
 * Users
 */
class Users
{
    /**
     * @var string
     */
    private $nom;

    /**
     * @var string
     */
    private $prenom;

    /**
     * @var \DateTime
     */
    private $dateNaissance;

    /**
     * @var integer
     */
    private $cin;

    /**
     * @var string
     */
    private $email;

    /**
     * @var string
     */
    private $password;

    /**
     * @var integer
     */
    private $telephone;

    /**
     * @var string
     */
    private $adresse;

    /**
     * @var string
     */
    private $user;

    /**
     * @var integer
     */
    private $numCarteServ;

    /**
     * @var integer
     */
    private $idPharmacie;

    /**
     * @var integer
     */
    private $idCentre;

    /**
     * @var integer
     */
    private $idUsr;


    /**
     * Set nom
     *
     * @param string $nom
     *
     * @return Users
     */
    public function setNom($nom)
    {
        $this->nom = $nom;

        return $this;
    }

    /**
     * Get nom
     *
     * @return string
     */
    public function getNom()
    {
        return $this->nom;
    }

    /**
     * Set prenom
     *
     * @param string $prenom
     *
     * @return Users
     */
    public function setPrenom($prenom)
    {
        $this->prenom = $prenom;

        return $this;
    }

    /**
     * Get prenom
     *
     * @return string
     */
    public function getPrenom()
    {
        return $this->prenom;
    }

    /**
     * Set dateNaissance
     *
     * @param \DateTime $dateNaissance
     *
     * @return Users
     */
    public function setDateNaissance($dateNaissance)
    {
        $this->dateNaissance = $dateNaissance;

        return $this;
    }

    /**
     * Get dateNaissance
     *
     * @return \DateTime
     */
    public function getDateNaissance()
    {
        return $this->dateNaissance;
    }

    /**
     * Set cin
     *
     * @param integer $cin
     *
     * @return Users
     */
    public function setCin($cin)
    {
        $this->cin = $cin;

        return $this;
    }

    /**
     * Get cin
     *
     * @return integer
     */
    public function getCin()
    {
        return $this->cin;
    }

    /**
     * Set email
     *
     * @param string $email
     *
     * @return Users
     */
    public function setEmail($email)
    {
        $this->email = $email;

        return $this;
    }

    /**
     * Get email
     *
     * @return string
     */
    public function getEmail()
    {
        return $this->email;
    }

    /**
     * Set password
     *
     * @param string $password
     *
     * @return Users
     */
    public function setPassword($password)
    {
        $this->password = $password;

        return $this;
    }

    /**
     * Get password
     *
     * @return string
     */
    public function getPassword()
    {
        return $this->password;
    }

    /**
     * Set telephone
     *
     * @param integer $telephone
     *
     * @return Users
     */
    public function setTelephone($telephone)
    {
        $this->telephone = $telephone;

        return $this;
    }

    /**
     * Get telephone
     *
     * @return integer
     */
    public function getTelephone()
    {
        return $this->telephone;
    }

    /**
     * Set adresse
     *
     * @param string $adresse
     *
     * @return Users
     */
    public function setAdresse($adresse)
    {
        $this->adresse = $adresse;

        return $this;
    }

    /**
     * Get adresse
     *
     * @return string
     */
    public function getAdresse()
    {
        return $this->adresse;
    }

    /**
     * Set user
     *
     * @param string $user
     *
     * @return Users
     */
    public function setUser($user)
    {
        $this->user = $user;

        return $this;
    }

    /**
     * Get user
     *
     * @return string
     */
    public function getUser()
    {
        return $this->user;
    }

    /**
     * Set numCarteServ
     *
     * @param integer $numCarteServ
     *
     * @return Users
     */
    public function setNumCarteServ($numCarteServ)
    {
        $this->numCarteServ = $numCarteServ;

        return $this;
    }

    /**
     * Get numCarteServ
     *
     * @return integer
     */
    public function getNumCarteServ()
    {
        return $this->numCarteServ;
    }

    /**
     * Set idPharmacie
     *
     * @param integer $idPharmacie
     *
     * @return Users
     */
    public function setIdPharmacie($idPharmacie)
    {
        $this->idPharmacie = $idPharmacie;

        return $this;
    }

    /**
     * Get idPharmacie
     *
     * @return integer
     */
    public function getIdPharmacie()
    {
        return $this->idPharmacie;
    }

    /**
     * Set idCentre
     *
     * @param integer $idCentre
     *
     * @return Users
     */
    public function setIdCentre($idCentre)
    {
        $this->idCentre = $idCentre;

        return $this;
    }

    /**
     * Get idCentre
     *
     * @return integer
     */
    public function getIdCentre()
    {
        return $this->idCentre;
    }

    /**
     * Get idUsr
     *
     * @return integer
     */
    public function getIdUsr()
    {
        return $this->idUsr;
    }
}

