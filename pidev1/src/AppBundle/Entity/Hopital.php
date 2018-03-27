<?php

namespace AppBundle\Entity;

/**
 * Hopital
 */
class Hopital
{
    /**
     * @var string
     */
    private $nom;

    /**
     * @var string
     */
    private $type;

    /**
     * @var string
     */
    private $coodonnees;

    /**
     * @var string
     */
    private $image;

    /**
     * @var integer
     */
    private $idHopital;


    /**
     * Set nom
     *
     * @param string $nom
     *
     * @return Hopital
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
     * Set type
     *
     * @param string $type
     *
     * @return Hopital
     */
    public function setType($type)
    {
        $this->type = $type;

        return $this;
    }

    /**
     * Get type
     *
     * @return string
     */
    public function getType()
    {
        return $this->type;
    }

    /**
     * Set coodonnees
     *
     * @param string $coodonnees
     *
     * @return Hopital
     */
    public function setCoodonnees($coodonnees)
    {
        $this->coodonnees = $coodonnees;

        return $this;
    }

    /**
     * Get coodonnees
     *
     * @return string
     */
    public function getCoodonnees()
    {
        return $this->coodonnees;
    }

    /**
     * Set image
     *
     * @param string $image
     *
     * @return Hopital
     */
    public function setImage($image)
    {
        $this->image = $image;

        return $this;
    }

    /**
     * Get image
     *
     * @return string
     */
    public function getImage()
    {
        return $this->image;
    }

    /**
     * Get idHopital
     *
     * @return integer
     */
    public function getIdHopital()
    {
        return $this->idHopital;
    }
}

