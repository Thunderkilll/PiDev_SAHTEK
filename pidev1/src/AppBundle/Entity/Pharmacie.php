<?php

namespace AppBundle\Entity;

/**
 * Pharmacie
 */
class Pharmacie
{
    /**
     * @var string
     */
    private $nomPharmacie;

    /**
     * @var string
     */
    private $adresse;

    /**
     * @var integer
     */
    private $telephone;

    /**
     * @var integer
     */
    private $codePostal;

    /**
     * @var \DateTime
     */
    private $horaireTravail;

    /**
     * @var integer
     */
    private $idPharmacie;


    /**
     * Set nomPharmacie
     *
     * @param string $nomPharmacie
     *
     * @return Pharmacie
     */
    public function setNomPharmacie($nomPharmacie)
    {
        $this->nomPharmacie = $nomPharmacie;

        return $this;
    }

    /**
     * Get nomPharmacie
     *
     * @return string
     */
    public function getNomPharmacie()
    {
        return $this->nomPharmacie;
    }

    /**
     * Set adresse
     *
     * @param string $adresse
     *
     * @return Pharmacie
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
     * Set telephone
     *
     * @param integer $telephone
     *
     * @return Pharmacie
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
     * Set codePostal
     *
     * @param integer $codePostal
     *
     * @return Pharmacie
     */
    public function setCodePostal($codePostal)
    {
        $this->codePostal = $codePostal;

        return $this;
    }

    /**
     * Get codePostal
     *
     * @return integer
     */
    public function getCodePostal()
    {
        return $this->codePostal;
    }

    /**
     * Set horaireTravail
     *
     * @param \DateTime $horaireTravail
     *
     * @return Pharmacie
     */
    public function setHoraireTravail($horaireTravail)
    {
        $this->horaireTravail = $horaireTravail;

        return $this;
    }

    /**
     * Get horaireTravail
     *
     * @return \DateTime
     */
    public function getHoraireTravail()
    {
        return $this->horaireTravail;
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
}

