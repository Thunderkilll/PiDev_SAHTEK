<?php

namespace UserBundle\Entity;

/**
 * Medicament
 */
class Medicament
{
    /**
     * @var string
     */
    private $nomMedicament;

    /**
     * @var float
     */
    private $prix;

    /**
     * @var string
     */
    private $nomLabo;

    /**
     * @var string
     */
    private $usrrole;

    /**
     * @var integer
     */
    private $idMedicament;


    /**
     * Set nomMedicament
     *
     * @param string $nomMedicament
     *
     * @return Medicament
     */
    public function setNomMedicament($nomMedicament)
    {
        $this->nomMedicament = $nomMedicament;

        return $this;
    }

    /**
     * Get nomMedicament
     *
     * @return string
     */
    public function getNomMedicament()
    {
        return $this->nomMedicament;
    }

    /**
     * Set prix
     *
     * @param float $prix
     *
     * @return Medicament
     */
    public function setPrix($prix)
    {
        $this->prix = $prix;

        return $this;
    }

    /**
     * Get prix
     *
     * @return float
     */
    public function getPrix()
    {
        return $this->prix;
    }

    /**
     * Set nomLabo
     *
     * @param string $nomLabo
     *
     * @return Medicament
     */
    public function setNomLabo($nomLabo)
    {
        $this->nomLabo = $nomLabo;

        return $this;
    }

    /**
     * Get nomLabo
     *
     * @return string
     */
    public function getNomLabo()
    {
        return $this->nomLabo;
    }

    /**
     * Set usrrole
     *
     * @param string $usrrole
     *
     * @return Medicament
     */
    public function setUsrrole($usrrole)
    {
        $this->usrrole = $usrrole;

        return $this;
    }

    /**
     * Get usrrole
     *
     * @return string
     */
    public function getUsrrole()
    {
        return $this->usrrole;
    }

    /**
     * Get idMedicament
     *
     * @return integer
     */
    public function getIdMedicament()
    {
        return $this->idMedicament;
    }
}

