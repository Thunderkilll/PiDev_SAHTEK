<?php

namespace AppBundle\Entity;

/**
 * Articles
 */
class Articles
{
    /**
     * @var integer
     */
    private $titre;

    /**
     * @var integer
     */
    private $subT;

    /**
     * @var string
     */
    private $descript;

    /**
     * @var string
     */
    private $image;

    /**
     * @var integer
     */
    private $idUser;

    /**
     * @var integer
     */
    private $idArticle;


    /**
     * Set titre
     *
     * @param integer $titre
     *
     * @return Articles
     */
    public function setTitre($titre)
    {
        $this->titre = $titre;

        return $this;
    }

    /**
     * Get titre
     *
     * @return integer
     */
    public function getTitre()
    {
        return $this->titre;
    }

    /**
     * Set subT
     *
     * @param integer $subT
     *
     * @return Articles
     */
    public function setSubT($subT)
    {
        $this->subT = $subT;

        return $this;
    }

    /**
     * Get subT
     *
     * @return integer
     */
    public function getSubT()
    {
        return $this->subT;
    }

    /**
     * Set descript
     *
     * @param string $descript
     *
     * @return Articles
     */
    public function setDescript($descript)
    {
        $this->descript = $descript;

        return $this;
    }

    /**
     * Get descript
     *
     * @return string
     */
    public function getDescript()
    {
        return $this->descript;
    }

    /**
     * Set image
     *
     * @param string $image
     *
     * @return Articles
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
     * Set idUser
     *
     * @param integer $idUser
     *
     * @return Articles
     */
    public function setIdUser($idUser)
    {
        $this->idUser = $idUser;

        return $this;
    }

    /**
     * Get idUser
     *
     * @return integer
     */
    public function getIdUser()
    {
        return $this->idUser;
    }

    /**
     * Get idArticle
     *
     * @return integer
     */
    public function getIdArticle()
    {
        return $this->idArticle;
    }
}

