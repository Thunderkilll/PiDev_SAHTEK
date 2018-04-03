<?php

namespace UserBundle\Controller;

use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use UserBundle\Entity\Articles;

class NonConnectedController extends Controller
{
    public function indexAction()
    {
        $m=$this->getDoctrine()->getManager();
        $articles=$m->getRepository('UserBundle:Articles')->findAll();

        return $this->render('UserBundle:non_connected:test.html.twig',array('article'=>$articles));
    }
    public function AffQuestAction(Articles $article){
        return $this->render('UserBundle:non_connected:ShowQA.html.twig', array(
            'article' => $article ));

    }
    public function QuestionsAction()
    { $m=$this->getDoctrine()->getManager();
        $articles=$m->getRepository('UserBundle:Articles')->findAll();

        return $this->render('UserBundle:non_connected:Questions.html.twig',array('article'=>$articles));
    }

}
