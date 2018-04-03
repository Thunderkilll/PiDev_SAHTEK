<?php

namespace UserBundle\Controller;

use UserBundle\Entity\Articles;
use UserBundle\Form\ArticlesType;
use Sensio\Bundle\FrameworkExtraBundle\Configuration\Route;
use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\HttpFoundation\File\UploadFile;
use Symfony\Component\Filesystem\Filesystem;

/**
 * Article controller.
 *
 */
class ArticlesController extends Controller
{
    /**
     * Lists all article entities.
     *
     */
    public function indexAction(Request $request)
    {
        $em = $this->getDoctrine()->getManager();

        $articles = $em->getRepository('UserBundle:Articles')->findAll();
        $articles  = $this->get('knp_paginator')->paginate($articles ,
            $request->query->get('page', 1)/*le numéro de la page à afficher*/,
            3/*nbre d'éléments par page*/
        );
        return $this->render('articles/index.html.twig', array(
            'articles' => $articles,
        ));
    }

    /**
     * Creates a new article entity.
     *
     */
    public function newAction(Request $request)
    {
        $article = new Articles();
        $form =$this->createForm(ArticlesType::class,$article);
        $form->handleRequest($request);
        if($form->isValid() && $form->isSubmitted())
        {
            /**
             * @var UploadedFile $file
             */
            $file = $article->getImage();
            $fileName = md5(uniqid()).'.'.$file->guessExtension();
            $file->move(
                $this->getParameter('image_directory'),$fileName
            );
            $article->setImage($fileName);

            $m=$this->getDoctrine()->getManager();
            $m->persist($article);
            $m->flush();

            return $this->redirectToRoute('manager_articles_index');
        }
        return $this->render(':articles:new.html.twig',array('form'=>$form->createView()));

    }

    /**
     * Finds and displays a article entity.
     *
     */
    public function showAction(Articles $article)
    {
        $deleteForm = $this->createDeleteForm($article);

        return $this->render('articles/show.html.twig', array(
            'article' => $article,
            'delete_form' => $deleteForm->createView(),
        ));
    }

    /**
     * Displays a form to edit an existing article entity.
     *
     */
    public function editAction(Request $request, Articles $article)
    {

        $deleteForm = $this->createDeleteForm($article);
        $editForm = $this->createForm('UserBundle\Form\ArticlesType', $article);
        $editForm->handleRequest($request);

        if ($editForm->isSubmitted() && $editForm->isValid()) {
            /**
             * @var UploadedFile $file
             */
            $file = $article->getImage();
            $fileName = md5(uniqid()).'.'.$file->guessExtension();
            $file->move(
                $this->getParameter('image_directory'),$fileName
            );
            $article->setImage($fileName);
            $this->getDoctrine()->getManager()->flush();

            return $this->redirectToRoute('manager_articles_index');
        }

        return $this->render('articles/edit.html.twig', array(
            'article' => $article,
            'edit_form' => $editForm->createView(),
            'delete_form' => $deleteForm->createView(),
        ));
    }

    /**
     * Deletes a article entity.
     *
     */
    public function deleteAction(Request $request, Articles $article)
    {
        $form = $this->createDeleteForm($article);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            $em = $this->getDoctrine()->getManager();
            $em->remove($article);
            $em->flush();
        }

        return $this->redirectToRoute('manager_articles_index');
    }

    /**
     * Creates a form to delete a article entity.
     *
     * @param Articles $article The article entity
     *
     * @return \Symfony\Component\Form\Form The form
     */
    private function createDeleteForm(Articles $article)
    {
        return $this->createFormBuilder()
            ->setAction($this->generateUrl('manager_articles_delete', array('idArticle' => $article->getIdarticle())))
            ->setMethod('DELETE')
            ->getForm()
        ;
    }

    /**
     * @Route("/post/new" , name="new_post")
     * @param Request $request
     * @return \Symfony\Component\HttpFoundation\RedirectResponse|Response
     */
    public function ajoutQuestionAction(Request $request){

        $article = new Articles();
        $Form =$this->createForm(ArticlesType::class,$article);
        $Form->handleRequest($request);
        if($Form->isValid() && $Form->isSubmitted())
        {
            /**
             * @var UploadedFile $file
             */
            $file = $article->getImage();
            $fileName = md5(uniqid()).'.'.$file->guessExtension();
            $file->move(
                $this->getParameter('image_directory'),$fileName
            );
            $article->setImage($fileName);

            $m=$this->getDoctrine()->getManager();
            $m->persist($article);
            $m->flush();

            return $this->redirectToRoute('Page_questions');
        }
        return $this->render('UserBundle:menu_options:ajoutQuestion.html.twig',array('f'=>$Form->createView()));

    }

    /**
     * @Route("/post/show" , name="show_post")
     *
     */

    public function listAction()
    {
        $m=$this->getDoctrine()->getManager();
        $articles=$m->getRepository('UserBundle:Articles')->findAll();

        return $this->render('UserBundle:menu_options:QandA.html.twig',array('article'=>$articles));
    }


}
