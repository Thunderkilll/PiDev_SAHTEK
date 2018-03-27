<?php

namespace AppBundle\Entity;

/**
 * CarteService
 */
class CarteService
{
    /**
     * @var integer
     */
    private $idCarteService;

    /**
     * @var string
     */
    private $specialite;

    /**
     * @var integer
     */
    private $numCarteService;


    /**
     * Set idCarteService
     *
     * @param integer $idCarteService
     *
     * @return CarteService
     */
    public function setIdCarteService($idCarteService)
    {
        $this->idCarteService = $idCarteService;

        return $this;
    }

    /**
     * Get idCarteService
     *
     * @return integer
     */
    public function getIdCarteService()
    {
        return $this->idCarteService;
    }

    /**
     * Set specialite
     *
     * @param string $specialite
     *
     * @return CarteService
     */
    public function setSpecialite($specialite)
    {
        $this->specialite = $specialite;

        return $this;
    }

    /**
     * Get specialite
     *
     * @return string
     */
    public function getSpecialite()
    {
        return $this->specialite;
    }

    /**
     * Get numCarteService
     *
     * @return integer
     */
    public function getNumCarteService()
    {
        return $this->numCarteService;
    }
}

