<?php

namespace UserBundle\Entity;
use Doctrine\ORM\Mapping as ORM;

/**
 * @ORM\Entity
 * @ORM\Table(name="Articles")
 */
class Articles
{

    /**
     * @ORM\GeneratedValue
     * @ORM\Id
     * @ORM\Column (type="integer")
     */
    private $idArticle;
    /**
     * @ORM\Column (type="string" , length=255 )
     */

    private $titre;

    /**
     * @ORM\Column (type="string" , length=255 )
     */

    private $subT;

    /**
     * @ORM\Column (type="text" )
     */

    private $descript;

    /**
     * @ORM\Column (type="string" , length=255)
     */

    private $image;



    /**
     * Set titre
     *
     * @param string $titre
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
     * @return string
     */
    public function getTitre()
    {
        return $this->titre;
    }

    /**
     * Set subT
     *
     * @param string $subT
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
     * @return string
     */
    public function getSubT()
    {
        return $this->subT;
    }

    /**
     * Set descript
     *
     * @param text $descript
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
     * @return text
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
     * Get idArticle
     *
     * @return integer
     */
    public function getIdArticle()
    {
        return $this->idArticle;
    }

}

